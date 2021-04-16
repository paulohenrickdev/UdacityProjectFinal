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
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val _userRepository = UserRepository(database)

    private val _eventNavigate = MutableLiveData<Boolean>()
    val eventNavigate: LiveData<Boolean>
        get() = _eventNavigate

    private val _loadingButton = MutableLiveData<Boolean>()
    val loadingButton: LiveData<Boolean>
        get() = _loadingButton

    /*TODO
     Quando clicar no botão de pesquisar o usuario, será salvo automaticamente e controlar o estado do loading
    O usuario podera clicar para ver o seu histórico. Irá ver o repositório do usuario que clicar
    */

    init {

    }

    fun searchUser(user: String) {
        Log.i("TAG", user)
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                _loadingButton.value = true
//                val user = _userRepository.getUserGithub(user)
//                _userRepository.insertUser(user.asDatabaseModel())
//                _loadingButton.value = false
//                _eventNavigate.value = true
//                Log.i("TESTE", user.toString())
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
    }

    fun navigate() {
        _eventNavigate.value = true
    }

    fun navigateComplete() {
        _eventNavigate.value = false
    }

}