package com.example.udacityprojectfinal.repository

import com.example.udacityprojectfinal.api.Network
import com.example.udacityprojectfinal.api.NetworkUser
import com.example.udacityprojectfinal.database.DatabaseUser
import com.example.udacityprojectfinal.database.UserDatabase

class UserRepository(private val databaseUser: UserDatabase) {
    suspend fun getUserGithub(user: String): NetworkUser {
        return Network.githubService.getUser(user)
    }

    fun insertUser(user: DatabaseUser) {
        databaseUser.userDao.insert(user)
    }
}