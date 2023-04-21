package com.auchtermuchty.pizzatime.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.auchtermuchty.pizzatime.PizzaTimeApplication

class OrderRepository(application: PizzaTimeApplication) {
    private var orderDao: OrderDao
    var allOrders: LiveData<List<Order>>

    private val database = OrderRoomDatabase.getDatabase(application)

    init {
        orderDao = database.orderDao()
        allOrders = orderDao.getOrders()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(order: Order) {
        orderDao.insert(order)
    }
}