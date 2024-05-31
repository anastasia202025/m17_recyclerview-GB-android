package com.example.hw17.data.model
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Camera(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "rover_id") val roverId: Int,
    @Json(name = "full_name") val fullName: String,
) : Parcelable
