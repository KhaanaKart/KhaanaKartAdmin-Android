package com.example.khaanakartadmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khaanakartadmin.adapters.MenuItemAdapter
import com.example.khaanakartadmin.databinding.ActivityViewMenuBinding
import com.example.khaanakartadmin.models.MenuItemModel

class ViewMenuActivity : AppCompatActivity() {

    private val binding: ActivityViewMenuBinding by lazy {
        ActivityViewMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val menuItemList = listOf(
            MenuItemModel("Burger", 8.99, R.drawable.burger, 1),
            MenuItemModel("Sandwich", 6.99, R.drawable.sandwich, 2),
            MenuItemModel("Chow Mein", 11.99, R.drawable.chowmein, 1),
            MenuItemModel("Salad", 8.99, R.drawable.salad, 1),
            MenuItemModel("Samosa", 4.99, R.drawable.samosa, 10),
            MenuItemModel("Omelette", 7.99, R.drawable.omelette, 3)
        )

        val adapter = MenuItemAdapter(menuItemList.toMutableList())
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.cartRecyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            this.finish()
        }

    }
}