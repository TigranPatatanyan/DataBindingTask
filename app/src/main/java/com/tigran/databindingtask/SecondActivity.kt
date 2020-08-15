package com.tigran.databindingtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tigran.databindingtask.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        binding.userviewmodel = userViewModel
        binding.lifecycleOwner = this
        userViewModel.setUsername(intent.getStringExtra("username"))
    }
}
