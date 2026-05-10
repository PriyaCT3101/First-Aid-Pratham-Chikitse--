package org.vtu.mindmatrix.prathamchikitse.ui.hospital

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import org.vtu.mindmatrix.prathamchikitse.data.EmergencyRepository
import org.vtu.mindmatrix.prathamchikitse.data.model.Hospital
import org.vtu.mindmatrix.prathamchikitse.databinding.ActivityHospitalsBinding
import org.vtu.mindmatrix.prathamchikitse.util.LanguageStore
import org.vtu.mindmatrix.prathamchikitse.util.LocationHelper
import com.google.android.gms.location.LocationCallback

class HospitalActivity : ComponentActivity() {
    private lateinit var binding: ActivityHospitalsBinding
    private lateinit var locationHelper: LocationHelper
    private var pendingHospital: Hospital? = null
    private var locationCallback: LocationCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        locationHelper = LocationHelper(this)
        val language = LanguageStore(this).language
        val adapter = HospitalAdapter(language, ::callHospital, ::navigateHospital)
        binding.tvHospitalsTitle.text = if (language == "kn") "ಹತ್ತಿರದ ಆಸ್ಪತ್ರೆಗಳು" else "Nearby hospitals"
        binding.btnBack.setOnClickListener { finish() }
        binding.rvHospitals.layoutManager = LinearLayoutManager(this)
        binding.rvHospitals.adapter = adapter

        // Initial submission of hospitals without distances
        adapter.submitList(EmergencyRepository.hospitals)

        checkPermissionsAndStartUpdates()
    }

    private fun checkPermissionsAndStartUpdates() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            startTracking()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 101)
        }
    }

    private fun startTracking() {
        val adapter = binding.rvHospitals.adapter as? HospitalAdapter ?: return
        locationCallback = locationHelper.startLocationUpdates { userLocation ->
            updateDistances(userLocation, adapter)
        }
    }

    private fun updateDistances(userLocation: Location, adapter: HospitalAdapter) {
        val hospitals = EmergencyRepository.hospitals
        hospitals.forEach { hospital ->
            val results = FloatArray(1)
            Location.distanceBetween(
                userLocation.latitude, userLocation.longitude,
                hospital.lat, hospital.lng,
                results
            )
            hospital.distanceKm = Math.round(results[0] / 1000.0 * 10.0) / 10.0
        }
        adapter.submitList(hospitals.sortedBy { it.distanceKm })
    }

    override fun onDestroy() {
        super.onDestroy()
        locationCallback?.let { locationHelper.stopLocationUpdates(it) }
    }

    private fun callHospital(hospital: Hospital) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:${hospital.phone}")))
        } else {
            pendingHospital = hospital
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL)
        }
    }

    private fun navigateHospital(hospital: Hospital) {
        val gmmIntentUri = Uri.parse("google.navigation:q=${hospital.lat},${hospital.lng}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            // Fallback to browser if Maps app is not available
            val browserUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=${hospital.lat},${hospital.lng}")
            startActivity(Intent(Intent.ACTION_VIEW, browserUri))
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL && grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED) {
            pendingHospital?.let(::callHospital)
        } else if (requestCode == 101 && grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED) {
            startTracking()
        }
    }

    companion object {
        private const val REQUEST_CALL = 40
    }
}
