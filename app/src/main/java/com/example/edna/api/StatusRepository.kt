package com.example.edna.api

import android.util.Log
import com.example.edna.data.Status
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StatusRepository(private val service: StatusService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {


    suspend fun loadStatus(): Result<Status> = withContext(dispatcher){
        try {
            val response = service.getStatus()
            if(response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                response.errorBody()?.string()?.let { Log.d("StatusRepo", it) }
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch(e: Exception) {
            e.message?.let { Log.d("StatusRepo", it) }
            Result.failure(e)
        }
    }
}