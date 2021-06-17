package com.example.something

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.something.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.etEmail.error = "Required"
                binding.etEmail.requestFocus()
            }
            if (password.isEmpty()) {
                binding.etPassword.error = "Required"
                binding.etPassword.requestFocus()
            }
            viewModel.init(email, password)
            observe()
        }
    }

    private fun observe() {
        viewModel.responseLiveData.observe(this, {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            d("RESPONSE: ", it.toString())
        })
    }



}