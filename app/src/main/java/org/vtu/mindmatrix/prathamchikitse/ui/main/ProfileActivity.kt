package org.vtu.mindmatrix.prathamchikitse.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import org.vtu.mindmatrix.prathamchikitse.databinding.ActivityProfileBinding
import org.vtu.mindmatrix.prathamchikitse.ui.auth.AuthActivity
import org.vtu.mindmatrix.prathamchikitse.ui.auth.ProfileSetupActivity
import org.vtu.mindmatrix.prathamchikitse.util.LanguageStore

class ProfileActivity : ComponentActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var store: LanguageStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        store = LanguageStore(this)

        renderProfile()

        binding.btnBack.setOnClickListener { finish() }

        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(this, ProfileSetupActivity::class.java)
            intent.putExtra("is_edit", true)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            store.isAuthenticated = false
            val intent = Intent(this, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        renderProfile()
    }

    private fun renderProfile() {
        binding.tvProfileName.text = "Name: ${store.getUserName()}"
        binding.tvProfilePhone.text = "Phone: ${store.userPhone}"
        binding.tvProfileAge.text = "Age: ${store.getUserAge()}"
        binding.tvProfileBlood.text = "Blood Group: ${store.getUserBlood()}"
        binding.tvProfileEmergency.text = "Emergency Contact: ${store.getUserEmergency()}"
        
        store.getUserPhoto()?.let {
            binding.ivProfileDisplay.setImageURI(Uri.parse(it))
            binding.ivProfileDisplay.setPadding(0, 0, 0, 0)
        }
    }
}
