package com.auchtermuchty.pizzatime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.pizzatime.adapter.ToppingsAdapter
import com.auchtermuchty.pizzatime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcyToppings.adapter = ToppingsAdapter()
        (binding.rcyToppings.adapter as ToppingsAdapter).toppingsStrings =
            mutableListOf(*resources.getStringArray(R.array.toppings))
    }
}