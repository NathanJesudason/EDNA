package com.example.edna.api

import com.example.edna.data.Status
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit

class CloseInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request().newBuilder().addHeader("Connection", "close").build()
        return chain.proceed(request)
    }
}

interface StatusService {
    @GET("api/status")
    suspend fun getStatus() : Response<Status>

    companion object {
        private val okHttpClient: OkHttpClient? = OkHttpClient.Builder()
            .addNetworkInterceptor(CloseInterceptor())
            .build();
        private const val BASE_URL = "http://192.168.1.1/"
        fun create() : StatusService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(StatusService::class.java)
        }
    }

}