package com.example.udacityprojectfinal.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.udacityprojectfinal.api.asDatabaseModel
import com.example.udacityprojectfinal.database.getDatabase
import com.example.udacityprojectfinal.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val _userRepository = UserRepository(database)

    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate

    val _searchQuery = MutableLiveData<String>()

    private val _loadingButton = MutableLiveData<Boolean>()
    val loadingButton: LiveData<Boolean>
        get() = _loadingButton

    /*TODO
     Quando clicar no botão de pesquisar o usuario, será salvo automaticamente e controlar o estado do loading
    O usuario podera clicar para ver o seu histórico. Irá ver o repositório do usuario que clicar
    */

    init {

    }

    fun searchUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                showLoading()
                val user = _userRepository.getUserGithub(_searchQuery.value.toString())
                _userRepository.insertUser(user.asDatabaseModel())
                Log.i("TESTE", user.toString())
                showLoadingComplete()
//                navigate()
            } catch (e: Exception) {
                e.printStackTrace()
                showLoadingComplete()
            }
        }
    }

    private suspend fun showLoading() {
        withContext(Dispatchers.Main) {
            _loadingButton.value = true
        }
    }

    private suspend fun showLoadingComplete() {
        withContext(Dispatchers.Main) {
            _loadingButton.value = false
        }
    }

    fun navigate() {
        _eventNavigate.value = true
    }

    fun navigateComplete() {
        _eventNavigate.value = false
    }

}