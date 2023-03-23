package com.example.edna.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UtilitiesResponse(
    val response_text: String
)
