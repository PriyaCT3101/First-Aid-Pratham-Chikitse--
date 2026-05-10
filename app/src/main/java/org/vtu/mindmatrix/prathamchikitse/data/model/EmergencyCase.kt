package org.vtu.mindmatrix.prathamchikitse.data.model

data class EmergencyCase(
    val id: Int,
    val nameEn: String,
    val nameKn: String,
    val iconResName: String,
    val severity: String,
    val steps: List<EmergencyStep>
)
