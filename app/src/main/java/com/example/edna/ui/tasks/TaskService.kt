package com.example.edna.ui.tasks

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit


interface TaskService {

    @GET("api/status")
    suspend fun getStatus() : Response<Tasks>

    companion object {
        /*private val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("192.168.1.1", 80))
        private val okHttpClient: OkHttpClient? = OkHttpClient.Builder()
            .proxy(proxy)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()*/
        private const val BASE_URL = "http://192.168.1.1/"
        fun create() : TaskService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(TaskService::class.java)
        }
    }
}