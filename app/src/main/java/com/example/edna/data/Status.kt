package com.example.edna.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Status(
    val valves: List<Int>,
    val valvesCount: Int,
    val pressure: Int,
    val temperature: Double,
    val barometric: Double,
    val waterVolume: Double,
    val waterDepth: Double,
    val waterFlow: Double,
    val currentTask: Int?,
    val currentState: String,
    val lowBattery: Boolean,
    val sampleVolume: Double,
    val utc: Int

) : java.io.Serializable
