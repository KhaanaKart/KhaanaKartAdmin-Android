package com.example.khaanakartadmin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khaanakartadmin.databinding.MenuListItemBinding
import com.example.khaanakartadmin.models.MenuItemModel

class MenuItemAdapter(private val menuItemList: MutableList<MenuItemModel>): RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return MenuItemViewHolder(MenuListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return menuItemList.size
    }

    inner class MenuItemViewHolder(private val binding: MenuListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                foodName.text = menuItemList[position].name
                foodTotalPrice.text = menuItemList[position].price.toString()
                foodImage.setImageResource(menuItemList[position].imageResId)
                quantityText.text = menuItemList[position].quantity.toString()
            }

            binding.reduceItemButton.setOnClickListener {
                decreaseQuantity(position)
            }

            binding.addItemButton.setOnClickListener {
                increaseQuantity(position)
            }

            binding.removeItemButton.setOnClickListener {
                val itemPosition = adapterPosition
                if (itemPosition != RecyclerView.NO_POSITION) {
                    deleteItem(itemPosition)
                }
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (menuItemList[position].quantity > 1) {
                menuItemList[position].quantity--
                binding.quantityText.text = menuItemList[position].quantity.toString()
            }
        }

        private fun increaseQuantity(position: Int) {
            if (menuItemList[position].quantity < 10) {
                menuItemList[position].quantity++
                binding.quantityText.text = menuItemList[position].quantity.toString()
            }
        }

        private fun deleteItem(position: Int) {
            menuItemList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, menuItemList.size)
        }
    }
}
