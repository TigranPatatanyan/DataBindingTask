package com.tigran.databindingtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    var _username: MutableLiveData<String> = MutableLiveData("")
    var _password: MutableLiveData<String> = MutableLiveData("")
    var _color: MutableLiveData<Color> = MutableLiveData(Color.RED)

    var username: LiveData<String> = _username
    var password: LiveData<String> = _password
    var color: LiveData<Color> = _color

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
            _color.value = Color.GREEN
        } else {
            _color.value = Color.RED
        }
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
}