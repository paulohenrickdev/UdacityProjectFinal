package com.example.udacityprojectfinal.api

import androidx.room.Database
import com.example.udacityprojectfinal.database.DatabaseUser
import com.example.udacityprojectfinal.model.User
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
    @Json(name = "id") val id: Long,
    @Json(name = "login") val name: String,
    @Json(name = "followers") val followers: String,
    @Json(name = "following") val following: String,
    @Json(name = "avatar_url") val avatar_url: String,
    @Json(name = "email") val email: String?,
    @Json(name = "location") val location: String?,
    @Json(name = "public_repos")val publicRepos: Int
)


fun NetworkUser.asDatabaseModel(): DatabaseUser {
    return DatabaseUser(
        id,
        name,
        name,
        followers,
        following,
        avatar_url,
        location ?: "",
        publicRepos
    )
}