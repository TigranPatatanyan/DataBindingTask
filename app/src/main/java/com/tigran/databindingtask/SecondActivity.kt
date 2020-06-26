package com.tigran.databinding

import MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tigran.databindingtask.R
import com.tigran.databindingtask.databinding.ActivitySecondBinding

open class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        binding.executePendingBindings()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.changeUsernameText(intent.getStringExtra("username"))
        viewModel.changePasswordText(intent.getStringExtra("password"))
    }
}
