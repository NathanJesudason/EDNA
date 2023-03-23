package com.example.edna.api

import android.util.Log
import com.example.edna.data.UtilitiesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.internal.Util

class HyperflushRepository(private val service: HyperflushInterface, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {


    suspend fun doHyperflush(): Result<UtilitiesResponse> = withContext(dispatcher){
        try {
            val response = service.getHyperflush()
            if(response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                response.errorBody()?.string()?.let { Log.d("Hyperflush", it) }
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch(e: Exception) {
            e.message?.let { Log.d("Hyperflush", it) }
            Result.failure(e)
        }
    }

    suspend fun doValveReset(): Result<UtilitiesResponse> = withContext(dispatcher){
        try {
            val response = service.getResetValves()
            if(response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                response.errorBody()?.string()?.let { Log.d("ValveReset", it) }
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch(e: Exception) {
            e.message?.let { Log.d("ValveReset", it) }
            Result.failure(e)
        }
    }

    suspend fun doBubblePurge(): Result<UtilitiesResponse> = withContext(dispatcher){
        try {
            val response = service.getBubblePurge()
            if(response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                response.errorBody()?.string()?.let { Log.d("BubblePurge", it) }
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch(e: Exception) {
            e.message?.let { Log.d("BubblePurge", it) }
            Result.failure(e)
        }
    }

    suspend fun doRTCUpdate(): Result<UtilitiesResponse> = withContext(dispatcher){
        try {
            val response = service.getUpdateRTC()
            if(response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                response.errorBody()?.string()?.let { Log.d("RTCUpdate", it) }
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch(e: Exception) {
            e.message?.let { Log.d("RTCUpdate", it) }
            Result.failure(e)
        }
    }

}