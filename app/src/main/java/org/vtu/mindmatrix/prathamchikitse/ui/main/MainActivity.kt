package org.vtu.mindmatrix.prathamchikitse.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.GridLayoutManager
import org.vtu.mindmatrix.prathamchikitse.data.EmergencyRepository
import org.vtu.mindmatrix.prathamchikitse.databinding.ActivityMainBinding
import org.vtu.mindmatrix.prathamchikitse.ui.detail.DetailActivity
import org.vtu.mindmatrix.prathamchikitse.ui.hospital.HospitalActivity
import org.vtu.mindmatrix.prathamchikitse.util.LanguageStore
import org.vtu.mindmatrix.prathamchikitse.util.LocationHelper

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var store: LanguageStore
    private lateinit var adapter: EmergencyCaseAdapter
    private lateinit var locationHelper: LocationHelper
    private var isFlashOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        store = LanguageStore(this)
        locationHelper = LocationHelper(this)
        adapter = EmergencyCaseAdapter { selected ->
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_CASE_ID, selected.id)
            startActivity(intent)
        }

        binding.rvCases.layoutManager = GridLayoutManager(this, 2)
        binding.rvCases.adapter = adapter
        binding.btnHospitals.setOnClickListener { startActivity(Intent(this, HospitalActivity::class.java)) }
        binding.btnProfile.setOnClickListener { startActivity(Intent(this, ProfileActivity::class.java)) }
        binding.btnSOS.setOnClickListener { handleSOS() }
        binding.btnLanguage.setOnClickListener {
            store.language = if (store.language == "en") "kn" else "en"
            render()
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.btnFlashlight.setOnClickListener { toggleFlashlight() }

        render()
    }

    private fun filter(query: String) {
        val filtered = if (query.isEmpty()) {
            EmergencyRepository.cases
        } else {
            EmergencyRepository.cases.filter {
                it.nameEn.contains(query, ignoreCase = true) || it.nameKn.contains(query)
            }
        }
        adapter.submitList(filtered, store.language)
    }

    private fun toggleFlashlight() {
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            Toast.makeText(this, "No flashlight available", Toast.LENGTH_SHORT).show()
            return
        }

        val cameraManager = getSystemService(CameraManager::class.java)
        try {
            val cameraId = cameraManager.cameraIdList[0]
            isFlashOn = !isFlashOn
            cameraManager.setTorchMode(cameraId, isFlashOn)
            binding.btnFlashlight.imageAlpha = if (isFlashOn) 255 else 128
        } catch (e: Exception) {
            Toast.makeText(this, "Error toggling flashlight: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSOS() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            
            ActivityCompat.requestPermissions(this, arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.SEND_SMS,
                android.Manifest.permission.CALL_PHONE
            ), 100)
            return
        }

        val emergencyContact = store.getUserEmergency()
        if (emergencyContact.isEmpty()) {
            Toast.makeText(this, "Please set an emergency contact in your profile first!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ProfileActivity::class.java))
            return
        }

        locationHelper.getLastLocation { location ->
            val locationMsg = if (location != null) {
                " My location: https://www.google.com/maps/search/?api=1&query=${location.latitude},${location.longitude}"
            } else {
                " (Location unavailable)"
            }
            
            val message = "EMERGENCY! I need help immediately. ${store.getUserName()}.$locationMsg"
            
            try {
                val smsManager = getSystemService(SmsManager::class.java)
                smsManager.sendTextMessage(emergencyContact, null, message, null, null)
                Toast.makeText(this, "SOS Message Sent to $emergencyContact", Toast.LENGTH_SHORT).show()
                
                // Show choice for calling
                showCallChoiceDialog(emergencyContact)
            } catch (e: Exception) {
                Toast.makeText(this, "Failed to send SOS: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showCallChoiceDialog(emergencyContact: String) {
        val options = arrayOf("Call 108 (Ambulance)", "Call Emergency Contact ($emergencyContact)")
        android.app.AlertDialog.Builder(this)
            .setTitle("Emergency Call")
            .setItems(options) { _, which ->
                val number = if (which == 0) "108" else emergencyContact
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
                startActivity(intent)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onResume() {
        super.onResume()
        render()
    }

    private fun render() {
        val language = store.language
        binding.btnLanguage.text = if (language == "kn") "ಕನ್ನಡ" else "English"
        binding.tvTitle.text = if (language == "kn") "ತುರ್ತು ಪ್ರಥಮ ಚಿಕಿತ್ಸೆ" else "Emergency First Aid"
        binding.btnHospitals.text = if (language == "kn") "ಹತ್ತಿರದ ಆಸ್ಪತ್ರೆಗಳು" else "Nearby hospitals"
        adapter.submitList(EmergencyRepository.cases, language)
    }
}
