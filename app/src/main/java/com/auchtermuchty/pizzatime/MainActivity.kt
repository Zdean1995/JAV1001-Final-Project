package com.auchtermuchty.pizzatime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.auchtermuchty.pizzatime.adapter.ToppingsAdapter
import com.auchtermuchty.pizzatime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateOrder.setOnClickListener {
            //val toast = Toast.makeText(this, "$order added to order", Toast.LENGTH_SHORT)
            //toast.show()
            val intent = Intent(this, CreateOrderActivity::class.java)
            this.startActivity(intent)
        }

        binding.btnPreviousOrders.setOnClickListener {
            //val toast = Toast.makeText(this, "$order added to order", Toast.LENGTH_SHORT)
            //toast.show()
            val intent = Intent(this, PreviousOrdersActivity::class.java)
            this.startActivity(intent)
        }
    }
}