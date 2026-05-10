package org.vtu.mindmatrix.prathamchikitse.ui.detail

import android.content.Context
import android.os.*
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.viewpager2.widget.ViewPager2
import org.vtu.mindmatrix.prathamchikitse.data.EmergencyRepository
import org.vtu.mindmatrix.prathamchikitse.data.model.EmergencyStep
import org.vtu.mindmatrix.prathamchikitse.databinding.ActivityDetailBinding
import org.vtu.mindmatrix.prathamchikitse.util.LanguageStore
import org.vtu.mindmatrix.prathamchikitse.util.TtsHelper

class DetailActivity : ComponentActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var ttsHelper: TtsHelper
    private var steps: List<EmergencyStep> = emptyList()
    private var countDownTimer: CountDownTimer? = null
    
    private val handler = Handler(Looper.getMainLooper())
    private var isMetronomeRunning = false
    private val metronomeRunnable = object : Runnable {
        override fun run() {
            if (isMetronomeRunning) {
                vibratePulse()
                handler.postDelayed(this, 545) // ~110 BPM
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ttsHelper = TtsHelper(this)

        val caseId = intent.getIntExtra(EXTRA_CASE_ID, -1)
        val emergencyCase = EmergencyRepository.caseById(caseId)
        if (emergencyCase == null) {
            Toast.makeText(this, "Emergency case not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val language = LanguageStore(this).language
        steps = emergencyCase.steps
        binding.tvDetailTitle.text = if (language == "kn") emergencyCase.nameKn else emergencyCase.nameEn
        binding.btnBack.setOnClickListener { finish() }
        binding.stepPager.adapter = EmergencyStepAdapter(steps, language)
        
        binding.stepPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                ttsHelper.stop()
                updateTools(position)
            }
        })
        
        binding.btnSpeak.setOnClickListener {
            val step = steps.getOrNull(binding.stepPager.currentItem) ?: return@setOnClickListener
            ttsHelper.speak(if (language == "kn") step.instructionKn else step.instructionEn, language)
        }

        binding.btnStartTimer.setOnClickListener {
            val position = binding.stepPager.currentItem
            val step = steps[position]
            if (step.instructionEn.contains("CPR", true)) {
                toggleMetronome()
            } else {
                startCountDown(getTimerSeconds(step.instructionEn))
            }
        }
    }

    private fun updateTools(position: Int) {
        stopAllTools()
        val step = steps[position]
        val text = step.instructionEn
        
        when {
            text.contains("CPR", true) || text.contains("Compressions", true) -> {
                binding.timerLayout.visibility = View.VISIBLE
                binding.tvTimerLabel.text = "CPR Metronome (110 BPM)"
                binding.tvTimerCount.text = "PULSE"
                binding.btnStartTimer.text = "START BEAT"
            }
            text.contains("minutes", true) -> {
                binding.timerLayout.visibility = View.VISIBLE
                val mins = if (text.contains("20")) 20 else 15
                binding.tvTimerLabel.text = "Treatment Timer"
                binding.tvTimerCount.text = "$mins:00"
                binding.btnStartTimer.text = "START TIMER"
            }
            else -> {
                binding.timerLayout.visibility = View.GONE
            }
        }
    }

    private fun startCountDown(seconds: Int) {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(seconds * 1000L, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val sec = millisUntilFinished / 1000
                val min = sec / 60
                val s = sec % 60
                binding.tvTimerCount.text = String.format("%02d:%02d", min, s)
            }
            override fun onFinish() {
                binding.tvTimerCount.text = "DONE!"
                vibratePulse()
            }
        }.start()
        binding.btnStartTimer.text = "RESET"
    }

    private fun toggleMetronome() {
        if (isMetronomeRunning) {
            stopMetronome()
        } else {
            isMetronomeRunning = true
            handler.post(metronomeRunnable)
            binding.btnStartTimer.text = "STOP BEAT"
        }
    }

    private fun stopMetronome() {
        isMetronomeRunning = false
        handler.removeCallbacks(metronomeRunnable)
        binding.btnStartTimer.text = "START BEAT"
    }

    private fun stopAllTools() {
        countDownTimer?.cancel()
        stopMetronome()
    }

    private fun vibratePulse() {
        val vibrator = getSystemService(Vibrator::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(100)
        }
    }

    private fun getTimerSeconds(text: String): Int {
        return if (text.contains("20")) 1200 else 900
    }

    override fun onDestroy() {
        ttsHelper.release()
        stopAllTools()
        super.onDestroy()
    }

    companion object {
        const val EXTRA_CASE_ID = "extra_case_id"
    }
}
