package com.auchtermuchty.pizzatime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.pizzatime.model.OrderViewModel

class PreviousOrdersActivity : AppCompatActivity() {
    private lateinit var viewModel: OrderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_orders)
    }
}