package com.auchtermuchty.pizzatime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.pizzatime.databinding.ActivityMainBinding
import com.auchtermuchty.pizzatime.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = intent?.extras?.getString("Order")
        binding.textView2.text = intent?.extras?.getInt("Price").toString()
    }
}