package org.vtu.mindmatrix.prathamchikitse.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.vtu.mindmatrix.prathamchikitse.R
import org.vtu.mindmatrix.prathamchikitse.data.model.EmergencyStep
import org.vtu.mindmatrix.prathamchikitse.databinding.ItemEmergencyStepBinding

class EmergencyStepAdapter(
    private val steps: List<EmergencyStep>,
    private val language: String
) : RecyclerView.Adapter<EmergencyStepAdapter.StepViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StepViewHolder(ItemEmergencyStepBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        holder.bind(steps[position])
    }

    override fun getItemCount(): Int = steps.size

    inner class StepViewHolder(private val binding: ItemEmergencyStepBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(step: EmergencyStep) {
            binding.tvBadge.text = if (step.isDo) "DO" else "DONT"
            binding.tvBadge.setBackgroundResource(if (step.isDo) R.drawable.bg_badge_do else R.drawable.bg_badge_dont)
            binding.tvStepNumber.text = "Step ${step.stepNumber}"
            binding.tvStepTitle.text = if (language == "kn") step.titleKn else step.titleEn
            binding.tvInstruction.text = if (language == "kn") step.instructionKn else step.instructionEn
            binding.ivStep.setImageResource(iconFor(step.illustrationResName))
        }
    }

    private fun iconFor(name: String): Int = when (name) {
        "ic_burn" -> R.drawable.ic_burn
        "ic_bleeding" -> R.drawable.ic_bleeding
        "ic_choking" -> R.drawable.ic_choking
        "ic_fracture" -> R.drawable.ic_fracture
        "ic_seizure" -> R.drawable.ic_seizure
        "ic_bandage" -> R.drawable.ic_bandage
        "ic_elevate" -> R.drawable.ic_elevate
        "ic_cold" -> R.drawable.ic_cold
        "ic_recovery" -> R.drawable.ic_recovery
        else -> R.drawable.ic_first_aid
    }
}
