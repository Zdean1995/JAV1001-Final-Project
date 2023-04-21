package com.auchtermuchty.pizzatime.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface OrderDao {

    @Query("SELECT * FROM orders")
    fun getOrders(): LiveData<List<Order>>

    @Query("SELECT * FROM orders WHERE id = :id")
    fun getOrder(id: Int): LiveData<Order>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(order: Order)

    @Update
    suspend fun update(order: Order)

    @Delete
    suspend fun delete(order: Order)
}