package com.example.udacityprojectfinal.ui.historic

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.udacityprojectfinal.database.getDatabase
import com.example.udacityprojectfinal.model.User
import com.example.udacityprojectfinal.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoricViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val _userRepository = UserRepository(database)

    private val _navigateUser = MutableLiveData<User>()
    val navigateUser: LiveData<User>
        get() = _navigateUser

    lateinit var users: LiveData<List<User>>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                users = _userRepository.getAllUsers()
                Log.i("TESTE", users.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun navigate(user: User) {
        _navigateUser.value = user
    }

    fun navigateComplete() {
        _navigateUser.value = null
    }
}