package com.example.internetapiapp.network

import com.squareup.moshi.Json

data class MarsItem(
    val id: String,
    val type: String,
    val price: Double,
    @Json(name = "img_src") val imgSrc: String
)
