package com.tigran.databindingtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tigran.databindingtask.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var view_model: MainViewModel
    lateinit var userName:String
    lateinit var passWord:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        view_model = ViewModelProvider(this).get(MainViewModel::class.java)
        userName = intent.getStringExtra("username")
        passWord = intent.getStringExtra("password")
        view_model.changeUsernameText(userName)
        view_model.changePasswordText(passWord)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        binding.viewModel=view_model
        binding.executePendingBindings()


    }
}
