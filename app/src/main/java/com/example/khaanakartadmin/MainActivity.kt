package com.example.khaanakartadmin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khaanakartadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.addItemCardView.setOnClickListener {
            val intent = Intent(this, AddMenuItemsActivity::class.java)
            startActivity(intent)
        }

        binding.viewAllItemsCardView.setOnClickListener {
            val intent = Intent(this, ViewMenuActivity::class.java)
            startActivity(intent)
        }

        binding.orderStatusCardView.setOnClickListener {
            val intent = Intent(this, OrderStatusActivity::class.java)
            startActivity(intent)
        }

        binding.myProfileCardView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.createNewUserCardView.setOnClickListener {
            val intent = Intent(this, CreateNewUserActivity::class.java)
            startActivity(intent)
        }

        binding.pendingOrdersSection.setOnClickListener {
            val intent = Intent(this, PendingOrderActivity::class.java)
            startActivity(intent)
        }
    }
}