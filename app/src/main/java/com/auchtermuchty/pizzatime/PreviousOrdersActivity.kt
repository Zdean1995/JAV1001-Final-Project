package com.auchtermuchty.pizzatime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.auchtermuchty.pizzatime.adapter.OrdersAdapter
import com.auchtermuchty.pizzatime.databinding.ActivityPreviousOrdersBinding
import com.auchtermuchty.pizzatime.model.OrderViewModel
import com.auchtermuchty.pizzatime.model.OrderViewModelFactory

class PreviousOrdersActivity : AppCompatActivity() {
    private val viewModel: OrderViewModel by viewModels {
        OrderViewModelFactory((application as PizzaTimeApplication).repository)
    }

    private lateinit var binding: ActivityPreviousOrdersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_orders)
        binding = ActivityPreviousOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val order = intent?.extras?.getString("Order")

        if(!order.isNullOrBlank()) {
            val price = intent?.extras?.getInt("Price").toString()
            val delivery = intent?.extras?.getBoolean("Delivery")
            viewModel.addNewOrder(order, price, delivery!!)
        }

        if(!viewModel.orders.value.isNullOrEmpty()){
            binding.rcyOrders.adapter = OrdersAdapter()
            (binding.rcyOrders.adapter as OrdersAdapter).orders =
                viewModel.orders.value!!
        }
    }
}