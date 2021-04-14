package com.example.udacityprojectfinal.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.udacityprojectfinal.model.User

@Entity
data class DatabaseUser constructor(
    @PrimaryKey
    val id: Long,
    val login: String,
    val name: String,
    val followers: String,
    val following: String,
    val avatar_url: String,
    val location: String,
    val public_repos: Int
)

fun List<DatabaseUser>.asDomainModel() : List<User> {
    return map {
        User(
            it.id,
            it.login,
            it.name,
            it.followers,
            it.following,
            it.avatar_url,
            it.location,
            it.public_repos
        )
    }
}