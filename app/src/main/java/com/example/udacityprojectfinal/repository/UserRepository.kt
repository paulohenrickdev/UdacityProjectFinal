package com.example.udacityprojectfinal.repository

import com.example.udacityprojectfinal.api.Network
import com.example.udacityprojectfinal.api.NetworkUser

class UserRepository {
    suspend fun getUserGithub(): NetworkUser {
        val response = Network.githubService.getUser("paulohenrickdev")
        return response
    }
}