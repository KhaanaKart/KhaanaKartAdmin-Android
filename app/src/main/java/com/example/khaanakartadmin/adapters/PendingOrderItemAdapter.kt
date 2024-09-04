package com.example.khaanakartadmin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakartadmin.databinding.PendingOrderListItemBinding
import com.example.khaanakartadmin.models.PendingOrderItemModel
import com.example.khaanakartadmin.models.enums.OrderStatus

class PendingOrderItemAdapter(private val pendingOrdersItemList: MutableList<PendingOrderItemModel>, private val context: Context): RecyclerView.Adapter<PendingOrderItemAdapter.PendingOrdersItemViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingOrdersItemViewHolder {
        return PendingOrdersItemViewHolder(PendingOrderListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PendingOrdersItemViewHolder, position: Int) {
        holder.bind(position)
    }


    override fun getItemCount(): Int {
        return pendingOrdersItemList.count()
    }


    inner class PendingOrdersItemViewHolder(private val binding: PendingOrderListItemBinding): RecyclerView.ViewHolder(binding.root) {
        private var isOrderAccepted = false
        fun bind(position: Int) {
            binding.apply {
                orderCustomerName.text = pendingOrdersItemList[position].customerName
                orderFoodQuantity.text = pendingOrdersItemList[position].quantity.toString()
                orderFoodImage.setImageResource(pendingOrdersItemList[position].imageResId)

                acceptDispatchButton.apply {
                    if(!isOrderAccepted) {
                        text = OrderStatus.ACCEPT.text
                    } else {
                        text = OrderStatus.DISPATCH.text
                    }

                    setOnClickListener {
                        if(!isOrderAccepted) {
                            text = OrderStatus.DISPATCH.text
                            isOrderAccepted = true
                            showToast("Order is Accepted!")
                        } else {
                            pendingOrdersItemList.removeAt(adapterPosition)
                            notifyItemRemoved(adapterPosition)
                            showToast("Order is Dispatched!")
                        }
                    }
                }


            }
        }

        private fun showToast(message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}