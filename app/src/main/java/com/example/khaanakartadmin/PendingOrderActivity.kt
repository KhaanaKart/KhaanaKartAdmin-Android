package com.example.khaanakartadmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khaanakartadmin.adapters.OrderStatusItemAdapter
import com.example.khaanakartadmin.adapters.PendingOrderItemAdapter
import com.example.khaanakartadmin.databinding.ActivityPendingOrderBinding
import com.example.khaanakartadmin.models.OrderStatusItemModel
import com.example.khaanakartadmin.models.PendingOrderItemModel
import com.example.khaanakartadmin.models.enums.DeliveryStatus
import com.example.khaanakartadmin.models.enums.OrderStatus
import com.example.khaanakartadmin.models.enums.PaymentStatus

class PendingOrderActivity : AppCompatActivity() {

    private val binding: ActivityPendingOrderBinding by lazy {
        ActivityPendingOrderBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val pendingOrdersList = listOf(
            PendingOrderItemModel("Alex Doe", R.drawable.burger, 2),
            PendingOrderItemModel("Sam Smith", R.drawable.samosa, 3),
            PendingOrderItemModel("Taylor Johnson", R.drawable.chowmein, 1),
            PendingOrderItemModel("Casey Roee", R.drawable.chicken_wings, 10),
            PendingOrderItemModel("Morgan Taylor", R.drawable.pasta, 1),
            PendingOrderItemModel("Chris Davis", R.drawable.sandwich,6)
        )

        val adapter = PendingOrderItemAdapter(pendingOrdersList.toMutableList(), this)
        binding.pendingOrdersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.pendingOrdersRecyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            this.finish()
        }
    }
}