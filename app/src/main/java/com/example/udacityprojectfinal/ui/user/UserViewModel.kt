package com.example.udacityprojectfinal.ui.user

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.udacityprojectfinal.api.asDatabaseModel
import com.example.udacityprojectfinal.database.getDatabase
import com.example.udacityprojectfinal.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val database = getDatabase(application)
    private val _userRepository = UserRepository(database)

    private val _eventNavigateToRepositories = MutableLiveData<Boolean>()
    val eventNavigateToRepositories : LiveData<Boolean>
        get() = _eventNavigateToRepositories

    init {
        viewModelScope.launch {
            try {
                val user = withContext(Dispatchers.IO) {
                    _userRepository.getUserGithub()
                }
                    _userRepository.insertUser(user.asDatabaseModel())
                Log.i("TESTE", user.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun navigateToRepositories() {
        _eventNavigateToRepositories.value = true
    }

    fun navigateToRepositoriesComplete() {
        _eventNavigateToRepositories.value = false
    }
}