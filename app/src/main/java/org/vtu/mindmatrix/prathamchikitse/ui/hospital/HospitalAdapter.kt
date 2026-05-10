package org.vtu.mindmatrix.prathamchikitse.ui.hospital

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.vtu.mindmatrix.prathamchikitse.data.model.Hospital
import org.vtu.mindmatrix.prathamchikitse.databinding.ItemHospitalBinding

class HospitalAdapter(
    private val language: String,
    private val onCall: (Hospital) -> Unit,
    private val onNavigate: (Hospital) -> Unit
) : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {
    private var items: List<Hospital> = emptyList()

    fun submitList(hospitals: List<Hospital>) {
        items = hospitals
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HospitalViewHolder(ItemHospitalBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class HospitalViewHolder(private val binding: ItemHospitalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hospital: Hospital) {
            val isKn = language == "kn"
            binding.tvHospitalName.text = if (isKn) hospital.nameKn else hospital.nameEn
            binding.tvHospitalAddress.text = if (isKn) hospital.addressKn else hospital.addressEn
            binding.tvDistance.text = "${hospital.distanceKm} km"
            
            // Integrate phone number directly onto the call button
            val callText = if (isKn) "ಕರೆ: ${hospital.phone}" else "CALL: ${hospital.phone}"
            binding.btnCall.text = callText
            binding.btnCall.setOnClickListener { onCall(hospital) }
            
            binding.btnNavigate.text = if (isKn) "ಮಾರ್ಗ" else "NAVIGATE"
            binding.btnNavigate.setOnClickListener { onNavigate(hospital) }
        }
    }
}
