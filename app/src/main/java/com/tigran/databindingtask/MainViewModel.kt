package com.tigran.databindingtask

import android.graphics.Color.GREEN
import android.graphics.Color.RED
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    var _username: MutableLiveData<String> = MutableLiveData("")
    var _password: MutableLiveData<String> = MutableLiveData("")
    var _color: MutableLiveData<Int> = MutableLiveData(RED)

    var username: LiveData<String> = _username
    var password: LiveData<String> = _password
    var color: LiveData<Int> = _color

    fun changeUsernameText(userName: String) {
        _username.value = userName
        changeColor()
    }

    fun changePasswordText(passWord: String) {
        _password.value = passWord
        changeColor()
    }

    private fun changeColor() {
        if (_username.value!!.length >= 6 && _password.value!!.length >= 6) {
            _color.value = GREEN
        } else {
            _color.value = RED
        }
    }
}