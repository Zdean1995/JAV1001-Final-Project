package com.auchtermuchty.pizzatime.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Query("SELECT * from order ORDER BY id ASC")
    fun getOrders(): Flow<List<Order>>

    @Query("SELECT * from order WHERE id = :id")
    fun getOrder(id: Int): Flow<Order>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(order: Order)

    @Update
    suspend fun update(order: Order)

    @Delete
    suspend fun delete(order: Order)
}