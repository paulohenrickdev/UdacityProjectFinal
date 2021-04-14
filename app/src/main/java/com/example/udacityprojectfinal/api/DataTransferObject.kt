package com.example.udacityprojectfinal.api

import com.example.udacityprojectfinal.model.Repository
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetWorkRepository(
    val language: String,
    val description: String,
    val name: String
)

fun NetWorkRepository.asDomainModel(): Repository {
    return Repository(
        language = language,
        description = description,
        name = name
    )
}

data class NetworkUser(
    val name: String,
    val followers: String,
    val following: String,
    val avatar_url: String,
    val location: String,
    val public_repos: Int
)

//@JsonClass(generateAdapter = true)
//data class Network