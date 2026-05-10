package org.vtu.mindmatrix.prathamchikitse.ui.auth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import org.vtu.mindmatrix.prathamchikitse.databinding.ActivityProfileSetupBinding
import org.vtu.mindmatrix.prathamchikitse.ui.main.MainActivity
import org.vtu.mindmatrix.prathamchikitse.util.LanguageStore

class ProfileSetupActivity : ComponentActivity() {
    private lateinit var binding: ActivityProfileSetupBinding
    private lateinit var store: LanguageStore
    private var phoneNumber: String = ""
    private var isEdit: Boolean = false
    private var selectedPhotoUri: Uri? = null

    private val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            selectedPhotoUri = uri
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            binding.ivProfilePhoto.setImageURI(uri)
            binding.ivProfilePhoto.setPadding(0, 0, 0, 0)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        store = LanguageStore(this)
        isEdit = intent.getBooleanExtra("is_edit", false)
        phoneNumber = intent.getStringExtra("phone") ?: store.userPhone

        if (isEdit) {
            binding.tvSetupTitle.text = "Edit Profile"
            binding.tvSetupSubtitle.text = "Update your information below."
            binding.etName.setText(store.getUserName())
            binding.etAge.setText(store.getUserAge())
            binding.etBloodGroup.setText(store.getUserBlood())
            binding.etEmergencyContact.setText(store.getUserEmergency())
            binding.btnSaveProfile.text = "UPDATE PROFILE"
            
            store.getUserPhoto()?.let {
                val uri = Uri.parse(it)
                selectedPhotoUri = uri
                binding.ivProfilePhoto.setImageURI(uri)
                binding.ivProfilePhoto.setPadding(0, 0, 0, 0)
            }
        }

        binding.btnPickPhoto.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        binding.btnSaveProfile.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val age = binding.etAge.text.toString().trim()
            val blood = binding.etBloodGroup.text.toString().trim()
            val emergency = binding.etEmergencyContact.text.toString().trim()

            if (name.isEmpty() || age.isEmpty() || blood.isEmpty() || emergency.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            // Validate emergency contact is exactly 10 digits
            val cleanEmergency = emergency.filter { it.isDigit() }
            if (cleanEmergency.length != 10) {
                binding.etEmergencyContact.error = "Enter a valid 10-digit number"
                Toast.makeText(this, "Invalid emergency contact number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            store.saveProfile(name, phoneNumber, age, blood, cleanEmergency, selectedPhotoUri?.toString())
            
            if (isEdit) {
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        }
    }
}
