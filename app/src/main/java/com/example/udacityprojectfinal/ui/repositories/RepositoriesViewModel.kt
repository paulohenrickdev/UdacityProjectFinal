package com.example.udacityprojectfinal.ui.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udacityprojectfinal.api.Network
import com.example.udacityprojectfinal.api.NetworkRepositoryContainer
import com.example.udacityprojectfinal.api.asDomain
import com.example.udacityprojectfinal.database.getDatabase
import com.example.udacityprojectfinal.model.Repository
import com.example.udacityprojectfinal.model.User
import com.example.udacityprojectfinal.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RepositoriesViewModel(user: User, application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val _userRepository = UserRepository(database)

    val reposList = MutableLiveData<List<Repository>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val repos = _userRepository.getRepositoriesUserRepos(user.login)
                reposList.postValue(repos)
                Log.i("INFOREPOS", repos.first().toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}