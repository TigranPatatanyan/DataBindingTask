package com.tigran.databindingtask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    var username: MutableLiveData<String> = MutableLiveData("")
    var password: MutableLiveData<String> = MutableLiveData("")
    var color: MutableLiveData<Int> = MutableLiveData(R.color.colorGrey)

    fun changeUsernameText(userName: String) {
        username.value = userName
        changeColor(checkTextLength())
    }

    fun changePasswordText(passWord: String) {
        password.value = passWord
        changeColor(checkTextLength())
    }

    private fun changeColor(boolean: Boolean) {
        if (boolean) {
            color.value = R.color.colorGreen
        } else {
            color.value = R.color.colorGrey
        }
    }

    fun checkTextLength(): Boolean {
        return username.value!!.length > 6 && password.value!!.length > 6
    }
}