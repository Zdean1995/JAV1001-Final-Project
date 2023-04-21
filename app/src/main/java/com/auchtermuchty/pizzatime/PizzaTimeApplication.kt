package com.auchtermuchty.pizzatime

import android.app.Application
import com.auchtermuchty.pizzatime.data.OrderRepository
import com.auchtermuchty.pizzatime.data.OrderRoomDatabase

class PizzaTimeApplication : Application() {
    val database: OrderRoomDatabase by lazy { OrderRoomDatabase.getDatabase(this) }
    val repository by lazy { OrderRepository(this)}
}