package com.example.udacityprojectfinal.ui.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {
    private val _eventNavigateSearchUser = MutableLiveData<Boolean>()
    val eventNavigateInstructions : LiveData<Boolean>
        get() = _eventNavigateSearchUser

    fun navigateToSearchUser() {
        _eventNavigateSearchUser.value = true
    }

    fun navigateToSearchUserComplete() {
        _eventNavigateSearchUser.value = false
    }
}