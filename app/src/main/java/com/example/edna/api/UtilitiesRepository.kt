package com.example.edna.api

import android.util.Log
import com.example.edna.data.HyperflushResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HyperflushRepository(private val service: HyperflushInterface, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {


    suspend fun doHyperflush(): Result<HyperflushResponse> = withContext(dispatcher){
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

    suspend fun doValveReset(): Result<HyperflushResponse> = withContext(dispatcher){
        try {
            val response = service.getHyperflush()
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

    suspend fun doBubblePurge(): Result<HyperflushResponse> = withContext(dispatcher){
        try {
            val response = service.getHyperflush()
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

    suspend fun doRTCUpdate(): Result<HyperflushResponse> = withContext(dispatcher){
        try {
            val response = service.getHyperflush()
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