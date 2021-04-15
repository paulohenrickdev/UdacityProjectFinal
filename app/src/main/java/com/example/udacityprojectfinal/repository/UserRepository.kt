package com.example.udacityprojectfinal.repository

import com.example.udacityprojectfinal.api.Network
import com.example.udacityprojectfinal.api.NetworkUser
import com.example.udacityprojectfinal.database.DatabaseUser
import com.example.udacityprojectfinal.database.UserDatabase
import com.example.udacityprojectfinal.model.User

class UserRepository(private val databaseUser: UserDatabase) {
    suspend fun getUserGithub(): NetworkUser {
        val response = Network.githubService.getUser("paulohenrickdev")
        return response
    }

    suspend fun insertUser(user: DatabaseUser) {
        databaseUser.userDao.insert(user)
    }
}