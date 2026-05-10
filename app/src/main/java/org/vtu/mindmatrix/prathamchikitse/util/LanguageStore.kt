package org.vtu.mindmatrix.prathamchikitse.util

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class LanguageStore(context: Context) {
    private val prefs: SharedPreferences = securePrefs(context)

    var language: String
        get() = prefs.getString(KEY_LANGUAGE, "en") ?: "en"
        set(value) = prefs.edit().putString(KEY_LANGUAGE, value).apply()

    var isAuthenticated: Boolean
        get() = prefs.getBoolean(KEY_AUTH, false)
        set(value) = prefs.edit().putBoolean(KEY_AUTH, value).apply()

    var isProfileComplete: Boolean
        get() = prefs.getBoolean(KEY_PROFILE_COMPLETE, false)
        set(value) = prefs.edit().putBoolean(KEY_PROFILE_COMPLETE, value).apply()

    var userPhone: String
        get() = prefs.getString(KEY_USER_PHONE, "") ?: ""
        set(value) = prefs.edit().putString(KEY_USER_PHONE, value).apply()

    fun saveProfile(name: String, phone: String, age: String, bloodGroup: String, emergencyContact: String, photoUri: String? = null) {
        prefs.edit().apply {
            putString(KEY_USER_NAME, name)
            putString(KEY_USER_PHONE, phone)
            putString(KEY_USER_AGE, age)
            putString(KEY_USER_BLOOD, bloodGroup)
            putString(KEY_USER_EMERGENCY, emergencyContact)
            putString(KEY_USER_PHOTO, photoUri)
            putBoolean(KEY_PROFILE_COMPLETE, true)
        }.apply()
    }

    fun getUserName(): String = prefs.getString(KEY_USER_NAME, "") ?: ""
    fun getUserAge(): String = prefs.getString(KEY_USER_AGE, "") ?: ""
    fun getUserBlood(): String = prefs.getString(KEY_USER_BLOOD, "") ?: ""
    fun getUserEmergency(): String = prefs.getString(KEY_USER_EMERGENCY, "") ?: ""
    fun getUserPhoto(): String? = prefs.getString(KEY_USER_PHOTO, null)

    companion object {
        private const val KEY_LANGUAGE = "language"
        private const val KEY_AUTH = "authenticated"
        private const val KEY_PROFILE_COMPLETE = "profile_complete"
        private const val KEY_USER_NAME = "user_name"
        private const val KEY_USER_PHONE = "user_phone"
        private const val KEY_USER_AGE = "user_age"
        private const val KEY_USER_BLOOD = "user_blood"
        private const val KEY_USER_EMERGENCY = "user_emergency"
        private const val KEY_USER_PHOTO = "user_photo"

        private fun securePrefs(context: Context): SharedPreferences {
            val masterKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
            
            val fileName = "pratham_chikitse_secure_prefs"
            
            return try {
                EncryptedSharedPreferences.create(
                    context,
                    fileName,
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
            } catch (e: Exception) {
                // If there's a crypto error (like AEADBadTagException), clear the corrupted prefs and retry
                context.getSharedPreferences(fileName, Context.MODE_PRIVATE).edit().clear().apply()
                
                // Log or handle the error if necessary, though resetting is the standard recovery
                EncryptedSharedPreferences.create(
                    context,
                    fileName,
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
            }
        }
    }
}
