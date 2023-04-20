package com.auchtermuchty.pizzatime.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.auchtermuchty.pizzatime.data.OrderDao

class OrderViewModel(orderDao: OrderDao): ViewModel() {
    val orders = orderDao.getOrders()

}

class OrderViewModelFactory(
    private val orderDao: OrderDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OrderViewModel(orderDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}