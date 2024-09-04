package com.example.khaanakartadmin.models.enums

enum class PaymentStatus(val color: Int, val text: String) {
    RECEIVED(android.graphics.Color.GREEN, "Received"),
    NOT_RECEIVED(android.graphics.Color.RED, "Not Received")
}