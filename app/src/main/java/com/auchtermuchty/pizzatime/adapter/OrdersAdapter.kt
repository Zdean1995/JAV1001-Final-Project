package com.auchtermuchty.pizzatime.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.auchtermuchty.pizzatime.R
import com.auchtermuchty.pizzatime.data.Order

class OrdersAdapter: RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    var orders: List<Order> = listOf()

    class OrdersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtOrder = view.findViewById(R.id.txt_orders_string) as TextView
        val txtPrice = view.findViewById(R.id.txt_orders_price) as TextView
        val txtDelivery = view.findViewById(R.id.txt_orders_delivery) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.orders_item, parent, false)

        return OrdersViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = orders.count()


    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.txtOrder.text = orders[position].orderString
        holder.txtPrice.text = orders[position].price.toString()
        if(orders[position].delivery){
            holder.txtDelivery.text = "Delivery"
        } else {
            holder.txtDelivery.text = "Pick Up"
        }
    }
}