package com.example.udacityprojectfinal.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.udacityprojectfinal.api.NetworkUser
import com.example.udacityprojectfinal.api.asDatabaseModel
import com.example.udacityprojectfinal.api.asDomain
import com.example.udacityprojectfinal.database.getDatabase
import com.example.udacityprojectfinal.model.User
import com.example.udacityprojectfinal.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val _userRepository = UserRepository(database)

    private val _user = MutableLiveData<User>()
    val user : LiveData<User>
        get() = _user

    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate

    val _searchQuery = MutableLiveData<String>()

    private val _loadingButton = MutableLiveData<Boolean>()
    val loadingButton: LiveData<Boolean>
        get() = _loadingButton

    private val _error = MutableLiveData(false)
    val error : LiveData<Boolean>
        get() = _error

    private val _eventNavigateToHist = MutableLiveData<Boolean>()
    val eventNavigateToHist: LiveData<Boolean>
        get() = _eventNavigateToHist

    fun searchUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                showLoading()
                val user = _userRepository.getUserGithub(_searchQuery.value.toString())
                _userRepository.insertUser(user.asDatabaseModel())
                convertNetworkUserAsUser(user)
                showLoadingComplete()
                navigate()
            } catch (e: Exception) {
                e.printStackTrace()
                showLoadingComplete()
                errorCallAPI()
            }
        }
    }

    fun navigateToHist() {
        _eventNavigateToHist.value = true
    }

    fun navigateToHistComplete() {
        _eventNavigateToHist.value = false
    }

    private fun convertNetworkUserAsUser(user: NetworkUser) {
        _user.postValue(user.asDomain())
    }

    private suspend fun showLoading() {
        withContext(Dispatchers.Main) {
            _loadingButton.postValue(true)
        }
    }

    private suspend fun showLoadingComplete() {
        withContext(Dispatchers.Main) {
            _loadingButton.postValue(false)
        }
    }

    suspend fun errorCallAPI() {
        withContext(Dispatchers.Main) {
            _error.postValue(true)
        }
    }

    private fun navigate() {
        _eventNavigate.postValue(true)
    }

    fun navigateComplete() {
        _eventNavigate.value = false
    }

}