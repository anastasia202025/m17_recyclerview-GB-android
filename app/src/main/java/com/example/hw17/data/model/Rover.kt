package com.example.hw17.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Rover(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "landing_date") val landingDate: String,
    @Json(name = "launch_date") val launchDate: String,
    @Json(name = "status") val status: String,
    @Json(name = "max_sol") val maxTotal: Int,
    @Json(name = "max_date") val maxData: String,
    @Json(name = "total_photos") val totalPhotos: Int,
    @Json(name = "cameras") val cameras: List<Cameras>
) : Parcelable
