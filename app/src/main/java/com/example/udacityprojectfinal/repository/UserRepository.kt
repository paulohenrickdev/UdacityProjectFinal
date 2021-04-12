package com.example.udacityprojectfinal.repository

import com.example.udacityprojectfinal.api.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserRepository {
    suspend fun getUserGithub() {
        GlobalScope.launch(Dispatchers.IO) {
            Network.githubService.getUser("paulohenrickdev")
        }
    }
}