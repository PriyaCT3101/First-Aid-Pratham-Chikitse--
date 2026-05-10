package org.vtu.mindmatrix.prathamchikitse.data.model

data class EmergencyStep(
    val stepNumber: Int,
    val titleEn: String,
    val titleKn: String,
    val instructionEn: String,
    val instructionKn: String,
    val isDo: Boolean,
    val illustrationResName: String
)
