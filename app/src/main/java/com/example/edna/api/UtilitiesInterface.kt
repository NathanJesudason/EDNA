package com.example.edna.api

import com.example.edna.data.UtilitiesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST


interface HyperflushInterface {
    @GET("api/preload")
    suspend fun getHyperflush(): Response<UtilitiesResponse>

    @GET("api/valves/reset")
    suspend fun getResetValves(): Response<UtilitiesResponse>

    @GET("api/alcohol-debubbler")
    suspend fun getBubblePurge(): Response<UtilitiesResponse>

    @POST("api/rtc/update")
    suspend fun getUpdateRTC(): Response<UtilitiesResponse>

    companion object {
        private const val BASE_URL = "http://192.168.1.1/"
        fun create() : HyperflushInterface {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(HyperflushInterface::class.java)

        }
    }
}