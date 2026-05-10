package org.vtu.mindmatrix.prathamchikitse.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.vtu.mindmatrix.prathamchikitse.R
import org.vtu.mindmatrix.prathamchikitse.data.model.EmergencyCase
import org.vtu.mindmatrix.prathamchikitse.databinding.ItemEmergencyCaseBinding

class EmergencyCaseAdapter(
    private val onCaseSelected: (EmergencyCase) -> Unit
) : RecyclerView.Adapter<EmergencyCaseAdapter.CaseViewHolder>() {
    private var language = "en"
    private var items: List<EmergencyCase> = emptyList()

    fun submitList(cases: List<EmergencyCase>, activeLanguage: String) {
        items = cases
        language = activeLanguage
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CaseViewHolder(ItemEmergencyCaseBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CaseViewHolder(private val binding: ItemEmergencyCaseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EmergencyCase) {
            binding.tvCaseName.text = if (language == "kn") item.nameKn else item.nameEn
            binding.tvSeverity.text = item.severity
            binding.ivCaseIcon.setImageResource(iconFor(item.iconResName))
            binding.root.setOnClickListener { onCaseSelected(item) }
        }
    }

    private fun iconFor(name: String): Int = when (name) {
        "ic_burn" -> R.drawable.ic_burn
        "ic_bleeding" -> R.drawable.ic_bleeding
        "ic_choking" -> R.drawable.ic_choking
        "ic_fracture" -> R.drawable.ic_fracture
        "ic_seizure" -> R.drawable.ic_seizure
        else -> R.drawable.ic_first_aid
    }
}
