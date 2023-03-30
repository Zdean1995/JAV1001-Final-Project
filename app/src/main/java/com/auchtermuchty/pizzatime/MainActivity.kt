package com.auchtermuchty.pizzatime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.pizzatime.adapter.ToppingsAdapter
import com.auchtermuchty.pizzatime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var price: Int = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcyToppings.adapter = ToppingsAdapter()
        (binding.rcyToppings.adapter as ToppingsAdapter).toppingsStrings =
            mutableListOf(*resources.getStringArray(R.array.toppings))

        binding.txtPrice.text = getString(R.string.price_txt, 0)

        binding.swtLarge.setOnClickListener{
            binding.swtMedium.isClickable = true
            binding.swtMedium.isChecked = false
            binding.swtSmall.isClickable = true
            binding.swtSmall.isChecked = false
            binding.swtLarge.isClickable = false
            price = 10
            calculatePrice()
        }

        binding.swtMedium.setOnClickListener{
            binding.swtLarge.isClickable = true
            binding.swtLarge.isChecked = false
            binding.swtSmall.isClickable = true
            binding.swtSmall.isChecked = false
            binding.swtMedium.isClickable = false
            price = 8
            calculatePrice()
        }

        binding.swtSmall.setOnClickListener{
            binding.swtLarge.isClickable = true
            binding.swtLarge.isChecked = false
            binding.swtMedium.isClickable = true
            binding.swtMedium.isChecked = false
            binding.swtSmall.isClickable = false
            price = 6
            calculatePrice()
        }

        binding.swtLarge.callOnClick()

    }

    fun calculatePrice(){
        binding.txtPrice.text = getString(R.string.price_txt, (binding.rcyToppings.adapter as ToppingsAdapter).toppingsCount + price)
    }
}