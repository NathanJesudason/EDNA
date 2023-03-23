package com.example.edna.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HyperflushResponse(
    val response_text: String
)
