package com.example.udacityprojectfinal.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate


    init {
//        getDatabase(application)
    }

    fun navigate() {
        _eventNavigate.value = true
    }

    fun navigateComplete() {
        _eventNavigate.value = false
    }

}