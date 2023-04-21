package com.auchtermuchty.pizzatime.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "order_string") val orderString: String,
    @ColumnInfo(name = "delivery") val delivery: Boolean,
    @ColumnInfo(name = "price") val price: String
)