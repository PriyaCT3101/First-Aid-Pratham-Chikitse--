package org.vtu.mindmatrix.prathamchikitse.ui.auth

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.vtu.mindmatrix.prathamchikitse.databinding.ActivityAuthBinding
import org.vtu.mindmatrix.prathamchikitse.ui.main.MainActivity
import org.vtu.mindmatrix.prathamchikitse.util.LanguageStore

class AuthActivity : ComponentActivity() {
    private lateinit var binding: ActivityAuthBinding
    private lateinit var store: LanguageStore
    private var currentOtp: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        store = LanguageStore(this)
        if (store.isAuthenticated) {
            openDashboard()
            return
        }

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetOtp.setOnClickListener {
            val phoneText = binding.etPhone.text.toString()
            val digits = phoneText.filter(Char::isDigit)
            
            if (digits.length == 10 && phoneText == digits) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendOtpSms(phoneText)
                } else {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 102)
                }
            } else {
                binding.etPhone.error = "Invalid: Enter a valid 10-digit phone number"
                Toast.makeText(this, "Enter the valid phone number", Toast.LENGTH_SHORT).show()
                
                binding.etOtp.visibility = View.GONE
                binding.btnVerify.visibility = View.GONE
            }
        }

        binding.btnVerify.setOnClickListener {
            val enteredOtp = binding.etOtp.text.toString()
            if (enteredOtp == currentOtp) {
                val phone = binding.etPhone.text.toString()
                store.userPhone = phone
                store.isAuthenticated = true
                
                if (store.isProfileComplete) {
                    openDashboard()
                } else {
                    val intent = Intent(this, ProfileSetupActivity::class.java)
                    intent.putExtra("phone", phone)
                    startActivity(intent)
                    finish()
                }
            } else {
                binding.etOtp.error = "Invalid OTP. Please check your SMS."
            }
        }
    }

    private fun sendOtpSms(phoneNumber: String) {
        val generated = (1000..9999).random().toString()
        currentOtp = generated
        
        // Display the OTP directly for the user as requested
        Toast.makeText(this, "OTP: $generated", Toast.LENGTH_LONG).show()
        
        binding.etOtp.visibility = View.VISIBLE
        binding.btnVerify.visibility = View.VISIBLE

        // Still attempt to send SMS in background for realism
        val formattedPhone = if (phoneNumber.length == 10) "+91$phoneNumber" else phoneNumber
        try {
            val smsManager: SmsManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                this.getSystemService(SmsManager::class.java)
            } else {
                @Suppress("DEPRECATION")
                SmsManager.getDefault()
            }
            val message = "Your Pratham Chikitse verification code is: $generated"
            smsManager.sendTextMessage(formattedPhone, null, message, null, null)
        } catch (e: Exception) {
            android.util.Log.e("AuthActivity", "Background SMS Error", e)
        }
    }

    private fun openDashboard() {
        if (!store.isProfileComplete) {
            val intent = Intent(this, ProfileSetupActivity::class.java)
            intent.putExtra("phone", store.userPhone)
            startActivity(intent)
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 102 && grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED) {
            sendOtpSms(binding.etPhone.text.toString())
        }
    }
}
