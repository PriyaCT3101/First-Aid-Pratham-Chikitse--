package org.vtu.mindmatrix.prathamchikitse.data.model

data class Hospital(
    val id: Int,
    val nameEn: String,
    val nameKn: String,
    var distanceKm: Double,
    val phone: String,
    val addressEn: String,
    val addressKn: String,
    val lat: Double,
    val lng: Double
)
