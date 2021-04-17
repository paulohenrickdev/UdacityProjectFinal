package com.example.udacityprojectfinal.ui.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.udacityprojectfinal.database.getDatabase
import com.example.udacityprojectfinal.model.User
import com.example.udacityprojectfinal.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositoriesViewModel(user: User, application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val _userRepository = UserRepository(database)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val repos = _userRepository.getRepositoriesUser(user.login)
                Log.i("INFOREPOS", repos.language)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}