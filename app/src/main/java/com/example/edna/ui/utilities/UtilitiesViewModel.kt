package com.example.edna.ui.utilities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edna.api.HyperflushInterface
import com.example.edna.api.HyperflushRepository
import kotlinx.coroutines.launch

class UtilitiesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is utilities Fragment"
    }
    val text: LiveData<String> = _text

    private val repository = HyperflushRepository(HyperflushInterface.create())


    fun requestHyperflush() {
        viewModelScope.launch {
            val result = repository.doHyperflush()

        }
    }

    fun requestValveReset() {
        viewModelScope.launch {
            val result = repository.doValveReset()
        }
    }

    fun requestBubblePurge() {
        viewModelScope.launch {
            val result = repository.doBubblePurge()
        }
    }

    fun requestRTCUpdate() {
        viewModelScope.launch {
            val result = repository.doRTCUpdate()
        }

    }
}