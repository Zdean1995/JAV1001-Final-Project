package com.auchtermuchty.pizzatime.adapter

import android.view.View
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.auchtermuchty.pizzatime.R

class ToppingsAdapter {

    private val toppingsStrings: List<String> = listOf(R.array.toppings.toString())

    class ToppingsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val swtToppings = view.findViewById(R.id.swt_toppings) as SwitchCompat
    }
}