package com.example.hw17.data

import com.example.hw17.data.model.PhotosMarsModel
import javax.inject.Inject

class Repository @Inject constructor() {
    suspend fun loadMars(): PhotosMarsModel {
        return RetrofitServices.nasaApi.getListMars()
    }
}