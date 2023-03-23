package com.example.edna.ui.tasks

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class TaskRepository(private val service: TaskService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun loadStatus(): Result<List<Tasks>> = withContext(dispatcher){
        try {
            val response = service.getStatus()
            if(response.isSuccessful) {
                Log.d("StatusRepo", "Success")
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