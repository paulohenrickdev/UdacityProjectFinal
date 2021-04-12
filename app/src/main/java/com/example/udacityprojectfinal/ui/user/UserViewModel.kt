package com.example.udacityprojectfinal.ui.user

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _eventNavigateToRepositories = MutableLiveData<Boolean>()
    val eventNavigateToRepositories : LiveData<Boolean>
        get() = _eventNavigateToRepositories

    fun navigateToRepositories() {
        _eventNavigateToRepositories.value = true
    }

    fun navigateToRepositoriesComplete() {
        _eventNavigateToRepositories.value = false
    }
}