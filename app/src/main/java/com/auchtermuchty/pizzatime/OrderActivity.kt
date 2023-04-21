package com.auchtermuchty.pizzatime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.pizzatime.databinding.ActivityMainBinding
import com.auchtermuchty.pizzatime.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val price = intent?.extras?.getInt("Price")
        val order = intent?.extras?.getString("Order")

        binding.txtOrder.text = order
        binding.txtPriceBeforeTax.text = price.toString()
        binding.btnConfirm.setOnClickListener {
            //val toast = Toast.makeText(this, "$order added to order", Toast.LENGTH_SHORT)
            //toast.show()
            val intent = Intent(this, PreviousOrdersActivity::class.java)
            intent.putExtra("Order", order)
            intent.putExtra("Price", price)
            intent.putExtra("Delivery", true)
            this.startActivity(intent)
        }
    }
}