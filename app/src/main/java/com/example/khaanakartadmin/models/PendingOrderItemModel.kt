package com.example.khaanakartadmin.models

import com.example.khaanakartadmin.models.enums.OrderStatus

data class PendingOrderItemModel(
    val customerName: String,
    val imageResId: Int,
    val quantity: Int
)
