package com.example.edna.ui.tasks

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel() {
    private val repository = TaskRepository(TaskService.create())

    private val _status = MutableLiveData<List<Tasks>>(null)
    /*private var _tasks: MutableList<Tasks> = mutableListOf()

        private val temp = listOf<Int>(8, 9, 10)
        private val temp3 = listOf<Int>(1, 2, 3)
        val example: List<Tasks> = listOf(Tasks(
            427041981,
            "Task 2",
            "Wee",
            0,
            1679438521,
            1679438520,
            50,
            0,
            30,
            40,
            25,
            60,
            50,
            0,
            false,
            temp
        ), Tasks(381830435,
            "Test Task",
            "For testing",
            0,
            946684983,
            946684980,
            17,
            0,
            60,
            35,
            10,
            20,
            60,
            0,
            false,
            temp3)
        )

        private val _temp = MutableLiveData<List<Tasks>?>().apply{
            value = example
        }

        val tasks = _temp
    */
    private val _tasks = MutableLiveData<List<Tasks>>(null)
    val tasks: LiveData<List<Tasks>> = _tasks

    private val _text = MutableLiveData<String>().apply {
        value = "This is tasks Fragment"
    }

    val text: LiveData<String> = _text

    fun loadSearchResults() {
        viewModelScope.launch {
            val result = repository.loadStatus()

            _status.value = result.getOrNull()
        }
    }


}