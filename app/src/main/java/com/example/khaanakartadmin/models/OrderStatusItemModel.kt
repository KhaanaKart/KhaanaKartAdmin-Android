package com.example.khaanakartadmin.models

import com.example.khaanakartadmin.models.enums.DeliveryStatus
import com.example.khaanakartadmin.models.enums.PaymentStatus

data class OrderStatusItemModel(
    val customerName: String,
    val paymentStatus: PaymentStatus,
    val deliveryStatus: DeliveryStatus
)
