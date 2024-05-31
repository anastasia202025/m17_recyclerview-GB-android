package com.example.hw17.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Mars (
    @Json(name = "id") val id: Int,
    @Json(name = "sol") val sol: Int,
    @Json(name = "camera") val camera: Camera,
    @Json(name = "img_src") val imgSrc: String,
    @Json(name = "earth_date") val earthDate: String,
    @Json(name = "rover") val rover: Rover
) : Parcelable
