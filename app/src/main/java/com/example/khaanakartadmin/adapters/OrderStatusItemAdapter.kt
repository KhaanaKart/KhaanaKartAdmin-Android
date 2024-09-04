package com.example.khaanakartadmin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakartadmin.databinding.OrderStatusListItemBinding
import com.example.khaanakartadmin.models.OrderStatusItemModel

class OrderStatusItemAdapter(private val orderStatusItemList: MutableList<OrderStatusItemModel>): RecyclerView.Adapter<OrderStatusItemAdapter.OrderStatusItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderStatusItemViewHolder {
        return OrderStatusItemViewHolder(OrderStatusListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OrderStatusItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return orderStatusItemList.count()
    }

    inner class OrderStatusItemViewHolder(private val binding: OrderStatusListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                customerName.text = orderStatusItemList[position].customerName
                paymentStatus.text = orderStatusItemList[position].paymentStatus.text
                paymentStatus.setTextColor(orderStatusItemList[position].paymentStatus.color)
                deliveryStatusCardView.setCardBackgroundColor(orderStatusItemList[position].deliveryStatus.color)
            }
        }
    }

}