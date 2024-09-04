package com.example.khaanakartadmin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khaanakartadmin.adapters.OrderStatusItemAdapter
import com.example.khaanakartadmin.databinding.ActivityOrderStatusBinding
import com.example.khaanakartadmin.models.OrderStatusItemModel
import com.example.khaanakartadmin.models.enums.DeliveryStatus
import com.example.khaanakartadmin.models.enums.PaymentStatus

class OrderStatusActivity : AppCompatActivity() {

    private val binding: ActivityOrderStatusBinding by lazy {
        ActivityOrderStatusBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val orderStatusList = listOf(
            OrderStatusItemModel("Alex Doe", PaymentStatus.RECEIVED, DeliveryStatus.DELIVERED),
            OrderStatusItemModel("Sam Smith", PaymentStatus.RECEIVED, DeliveryStatus.NOT_DELIVERED),
            OrderStatusItemModel("Taylor Johnson", PaymentStatus.NOT_RECEIVED, DeliveryStatus.DELIVERED),
            OrderStatusItemModel("Casey Roe", PaymentStatus.NOT_RECEIVED, DeliveryStatus.NOT_DELIVERED),
            OrderStatusItemModel("Jordan Brown", PaymentStatus.RECEIVED, DeliveryStatus.NOT_DELIVERED),
            OrderStatusItemModel("Morgan Taylor", PaymentStatus.NOT_RECEIVED, DeliveryStatus.DELIVERED),
            OrderStatusItemModel("Jamie White", PaymentStatus.NOT_RECEIVED, DeliveryStatus.DELIVERED),
            OrderStatusItemModel("Chris Davis", PaymentStatus.NOT_RECEIVED, DeliveryStatus.NOT_DELIVERED),
            OrderStatusItemModel("Pat Miller", PaymentStatus.NOT_RECEIVED, DeliveryStatus.NOT_DELIVERED),
            OrderStatusItemModel("Avery Green", PaymentStatus.RECEIVED, DeliveryStatus.NOT_DELIVERED)
        )

        val adapter = OrderStatusItemAdapter(orderStatusList.toMutableList())
        binding.orderStatusRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.orderStatusRecyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            this.finish()
        }
    }
}