package org.vtu.mindmatrix.prathamchikitse.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class TtsHelper(context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
    private var ready = false

    override fun onInit(status: Int) {
        ready = status == TextToSpeech.SUCCESS
    }

    fun speak(text: String, language: String) {
        val engine = tts ?: return
        if (!ready) return
        engine.language = if (language == "kn") Locale("kn", "IN") else Locale.ENGLISH
        engine.speak(text, TextToSpeech.QUEUE_FLUSH, null, "step-instruction")
    }

    fun stop() {
        tts?.stop()
    }

    fun release() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}
