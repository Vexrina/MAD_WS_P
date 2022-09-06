package com.example.shushufood_wearos

import android.app.Activity
import android.os.Bundle
import com.example.shushufood_wearos.databinding.ActivityLoginBinding

class LoginActivity : Activity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)

    }
}