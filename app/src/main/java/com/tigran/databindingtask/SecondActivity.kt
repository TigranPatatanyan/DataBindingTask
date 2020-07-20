package com.tigran.databindingtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tigran.databindingtask.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        viewModel.setUsername(intent.getStringExtra("username"))
    }
}
