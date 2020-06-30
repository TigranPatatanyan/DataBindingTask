package com.tigran.databindingtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tigran.databindingtask.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var view_model: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view_model = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = view_model
        binding.executePendingBindings()
        initTextWatchers()
    }

    private fun initTextWatchers() {
        user_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                view_model.changeUsernameText(p0.toString())
            }
        })
        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                view_model.changePasswordText(p0.toString())
            }
        })
    }

    fun login(view: View) {
        if (view_model.checkTextLength()) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", view_model.username.value)
            intent.putExtra("password", view_model.password.value)
            startActivity(intent)
            finish()
        } else {
            showToast()
        }
    }

    private fun showToast() {
        Toast.makeText(
            this,
            R.string.text_max_lenghs,
            Toast.LENGTH_SHORT
        ).show()
    }
}