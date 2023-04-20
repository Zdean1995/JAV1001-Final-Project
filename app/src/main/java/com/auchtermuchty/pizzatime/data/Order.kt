package com.auchtermuchty.pizzatime.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "order_string") val orderString: String,
    @NonNull @ColumnInfo(name = "delivery") val delivery: Boolean,
    @NonNull @ColumnInfo(name = "price") val price: Double
)