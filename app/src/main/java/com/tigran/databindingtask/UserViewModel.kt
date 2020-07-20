package com.tigran.databindingtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _username = MutableLiveData("")
    var username: LiveData<String> = _username
    fun setUsername(str: String) {
        _username.value = str
    }

    private val _likes = MutableLiveData(0)
    var likes: LiveData<Int> = _likes

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }
}