package com.example.udacityprojectfinal.repository

import com.example.udacityprojectfinal.api.*
import com.example.udacityprojectfinal.database.DatabaseUser
import com.example.udacityprojectfinal.database.UserDatabase
import com.example.udacityprojectfinal.model.Repository

class UserRepository(private val databaseUser: UserDatabase) {
    suspend fun getUserGithub(user: String): NetworkUser {
        return Network.githubService.getUser(user)
    }

    suspend fun getRepositoriesUserRepos(user: String) : List<Repository> {
        return NetworkRepositoryContainer(Network.githubService.getUserRepositories(user)).asDomain()
    }

    fun insertUser(user: DatabaseUser) {
        databaseUser.userDao.insert(user)
    }
}