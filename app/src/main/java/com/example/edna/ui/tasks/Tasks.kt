package com.example.edna.ui.tasks

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tasks(
    val id: Int,
    val name: String,
    val notes: String,
    val status: Int,
    val createdAt: Int,
    val schedule: Int,
    val flushTime: Int,
    val flushVolume: Int,
    val sampleTime: Int,
    val samplePressure: Int,
    val sampleVolume: Int,
    val preserveTime: Int,
    val timeBetween: Int,
    val valvesOffset: Int,
    val deleteOnCompletion: Boolean,
    val valves: List<Int>
) : java.io.Serializable
