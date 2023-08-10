package com.example.cocktailbar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailbar.R
import com.example.cocktailbar.database.CocktailItem
import com.example.cocktailbar.databinding.ItemViewBinding

class MyCocktailsAdapter(private val onItemClicked: (CocktailItem) -> Unit)
    : ListAdapter<CocktailItem, MyCocktailsAdapter.MyCocktailViewHolder>(DiffCallback) {

        class MyCocktailViewHolder(private var binding: ItemViewBinding)
            : RecyclerView.ViewHolder(binding.root) {
            fun bind(cocktailItem: CocktailItem) {
                binding.itemTextView.text = cocktailItem.title
                binding.itemImageView.setImageResource(R.drawable.summer_holidays_1)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCocktailViewHolder {
        val viewHolder = MyCocktailViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyCocktailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<CocktailItem>() {
            override fun areItemsTheSame(oldItem: CocktailItem, newItem: CocktailItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CocktailItem, newItem: CocktailItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}