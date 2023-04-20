package com.auchtermuchty.pizzatime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auchtermuchty.pizzatime.adapter.ToppingsAdapter
import com.auchtermuchty.pizzatime.databinding.ActivityCreateOrderBinding

class CreateOrderActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateOrderBinding
    //the price of the pizza
    private var price: Int = 0

    //the size of the pizza
    private var pizzaSize: String = ""

    //The full order string which will be used for adding the pizza to the full order
    private var order: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_order)
        binding = ActivityCreateOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcyToppings.adapter = ToppingsAdapter()

        //adding the string array to the recyclerView adapter.  This is done here since I couldn't
        //figure out a way to do it from inside the adapter
        (binding.rcyToppings.adapter as ToppingsAdapter).toppingsStrings =
            mutableListOf(*resources.getStringArray(R.array.toppings))


        //on click listeners for each of the size switches.  They all make it so you can't hit themselves again
        //and it unchecks the other two and makes them clickable again.
        binding.swtLarge.setOnClickListener{
            binding.swtMedium.isClickable = true
            binding.swtMedium.isChecked = false
            binding.swtSmall.isClickable = true
            binding.swtSmall.isChecked = false
            binding.swtLarge.isClickable = false
            price = 10
            pizzaSize = "Large"
            calculatePrice()
        }

        binding.swtMedium.setOnClickListener{
            binding.swtLarge.isClickable = true
            binding.swtLarge.isChecked = false
            binding.swtSmall.isClickable = true
            binding.swtSmall.isChecked = false
            binding.swtMedium.isClickable = false
            price = 8
            pizzaSize = "Medium"
            calculatePrice()
        }

        binding.swtSmall.setOnClickListener{
            binding.swtLarge.isClickable = true
            binding.swtLarge.isChecked = false
            binding.swtMedium.isClickable = true
            binding.swtMedium.isChecked = false
            binding.swtSmall.isClickable = false
            price = 6
            pizzaSize = "Small"
            calculatePrice()
        }

        //The on click listener for the add to order button.  This will do more later
        binding.btnAddToOrder.setOnClickListener {
            //val toast = Toast.makeText(this, "$order added to order", Toast.LENGTH_SHORT)
            //toast.show()
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("Order", order)
            intent.putExtra("Price", price)
            this.startActivity(intent)
        }

        //finally, sets the default option for pizza size to large
        binding.swtLarge.isChecked = true
        binding.swtLarge.callOnClick()
    }

    //The method for calculating the price and updating the UI
    private fun calculatePrice(){

        //this is needed to make the text more readable and also to the list isn't a reference to the one in the adapter
        val toppingsList: MutableList<String> = mutableListOf()
        toppingsList.addAll((binding.rcyToppings.adapter as ToppingsAdapter).selectedToppingsStrings)

        binding.txtPrice.text = getString(R.string.price_txt, (toppingsList.count() * 2) + price)

        when(toppingsList.count()) {
            0 -> binding.txtPizza.text = resources.getString(R.string.pizzaNoToppings, pizzaSize)
            1 -> binding.txtPizza.text = resources.getString(R.string.pizzaOneTopping, pizzaSize, toppingsList[0])
            else -> {
                val lastTopping = toppingsList.removeLast()
                val toppings = toppingsList.joinToString()
                binding.txtPizza.text = resources.getString(R.string.pizzaManyTopping, pizzaSize, toppings, lastTopping)
            }
        }
        order = binding.txtPizza.text.toString()
    }
}