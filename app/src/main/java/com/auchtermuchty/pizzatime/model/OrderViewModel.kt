package com.auchtermuchty.pizzatime.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.auchtermuchty.pizzatime.data.Order
import com.auchtermuchty.pizzatime.data.OrderDao

class OrderViewModel(private val orderDao: OrderDao) : ViewModel() {

    val allOrders: LiveData<List<Order>> = orderDao.getOrders().asLiveData()

    private val _orderString = MutableLiveData<String>()
    val orderString: LiveData<String> = _orderString

    private val _orderPrice = MutableLiveData<Double>()
    val orderPrice: LiveData<Double> = _orderPrice
}