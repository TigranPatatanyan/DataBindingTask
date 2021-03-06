package com.tigran.databindingtask

import android.graphics.Color.*
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

    private var _color: MutableLiveData<Int> = MutableLiveData(BLUE)
    var color: LiveData<Int> = _color

    fun onLike() {
        val likes: Int = (_likes.value ?: 0) + 1
        _likes.value = likes
        setColor(likes)
    }

    private fun setColor(like: Int) {
        when {
            like > 9 -> _color.value = RED
            like > 4 -> _color.value = YELLOW
            else -> _color.value = BLUE
        }
    }
}