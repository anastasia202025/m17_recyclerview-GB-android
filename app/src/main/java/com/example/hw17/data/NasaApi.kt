package com.example.hw17.data

import com.example.hw17.data.model.PhotosMarsModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&API_KEY=TgHV3W1wEnbPlUeJ42fo48WCE57r7PWqfU9H5b19
private const val BASE_URL = "https://api.nasa.gov"
const val API_KEY = "TgHV3W1wEnbPlUeJ42fo48WCE57r7PWqfU9H5b19"

object RetrofitServices {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val nasaApi: NasaApi = retrofit.create(NasaApi::class.java)
}
interface NasaApi {
    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=1000")
    suspend fun getListMars(
        @Query("api_key") apiKey: String = API_KEY
    ): PhotosMarsModel
}