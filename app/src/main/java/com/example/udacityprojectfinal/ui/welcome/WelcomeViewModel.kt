package com.example.udacityprojectfinal.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {
    private val _eventNavigateInstructions = MutableLiveData<Boolean>()
    val eventNavigateInstructions : LiveData<Boolean>
        get() = _eventNavigateInstructions

    fun navigateToInstruction() {
        _eventNavigateInstructions.value = true
    }

    fun navigateToInstructionComplete() {
        _eventNavigateInstructions.value = false
    }
}