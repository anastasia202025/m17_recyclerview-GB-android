package com.example.hw17.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PhotosMarsModel(
    @Json(name = "photos") val photos: List<Mars>
) : Parcelable
