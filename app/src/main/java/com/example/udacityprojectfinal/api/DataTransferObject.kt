package com.example.udacityprojectfinal.api

import com.example.udacityprojectfinal.database.DatabaseUser
import com.example.udacityprojectfinal.model.Repository
import com.example.udacityprojectfinal.model.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkRepository(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String?,
    @Json(name = "language") val language: String?,
)

@JsonClass(generateAdapter = true)
data class NetworkRepositoryContainer(val repos: List<NetworkRepository>)

fun NetworkRepositoryContainer.asDomain(): List<Repository> {
    return repos.map {
        Repository(
            it.id,
            it.name,
            it.description,
            it.language
        )
    }
}

@JsonClass(generateAdapter = true)
data class NetworkUser(
    @Json(name = "id") val id: Long,
    @Json(name = "login") val name: String,
    @Json(name = "followers") val followers: String,
    @Json(name = "following") val following: String,
    @Json(name = "avatar_url") val avatar_url: String,
    @Json(name = "email") val email: String?,
    @Json(name = "location") val location: String?,
    @Json(name = "public_repos") val publicRepos: String
)

fun NetworkUser.asDomain(): User {
    return User(
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