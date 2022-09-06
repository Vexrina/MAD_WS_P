package com.example.shushufood_wearos

import android.app.Activity
import android.os.Bundle
import com.example.shushufood_wearos.databinding.ActivityOrdersBinding

class OrdersActivity : Activity() {

    private lateinit var binding: ActivityOrdersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}