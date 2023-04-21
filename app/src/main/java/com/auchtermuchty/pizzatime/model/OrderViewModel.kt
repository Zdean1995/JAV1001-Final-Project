package com.auchtermuchty.pizzatime.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.auchtermuchty.pizzatime.data.Order
import com.auchtermuchty.pizzatime.data.OrderDao
import com.auchtermuchty.pizzatime.data.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel(private val repository: OrderRepository): ViewModel() {
    var orders = repository.allOrders

    fun addNewOrder(order: String, price: String, delivery: Boolean) {
        val newOrder = getNewOrderEntry(order, price, delivery)
        viewModelScope.launch {
            repository.insert(newOrder)
        }
    }

    private fun getNewOrderEntry(order: String, price: String, delivery: Boolean): Order {
        return Order(
            orderString = order,
            price = price,
            delivery = delivery
        )
    }

}

class OrderViewModelFactory(
    private val repository: OrderRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OrderViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}