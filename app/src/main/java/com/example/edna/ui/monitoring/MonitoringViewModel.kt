package com.example.edna.ui.monitoring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edna.api.StatusRepository
import com.example.edna.api.StatusService
import com.example.edna.data.Status
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MonitoringViewModel : ViewModel() {
    private val repository = StatusRepository(StatusService.create())

    private val _status = MutableLiveData<Status>(null)

    val statusResults: LiveData<Status> = _status


    fun loadSearchResults() {
        viewModelScope.launch {
            val result = repository.loadStatus()

            _status.value = result.getOrNull()
        }
    }


}

