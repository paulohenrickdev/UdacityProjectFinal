package com.example.udacityprojectfinal.api

import com.example.udacityprojectfinal.model.Repository
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetWorkRepository(
    val language: String,
    val description: String,
    val name: String
)

@JsonClass(generateAdapter = true)
data class NetworkUser(
    @Json(name = "login") val login: String,
    @Json(name = "login") val name: String,
    @Json(name = "followers") val followers: String,
    @Json(name = "following") val following: String,
    @Json(name = "avatar_url") val avatar_url: String,
    @Json(name = "email") val email: String
)