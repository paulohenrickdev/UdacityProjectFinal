package com.example.udacityprojectfinal.ui.user

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udacityprojectfinal.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class UserViewModel : ViewModel() {

    private val _userRepository = UserRepository()

    private val _eventNavigateToRepositories = MutableLiveData<Boolean>()
    val eventNavigateToRepositories : LiveData<Boolean>
        get() = _eventNavigateToRepositories

    init {
        viewModelScope.launch {
            try {
                val user = _userRepository.getUserGithub()
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

    suspend fun getUserOnGithubApi() {

    }
}