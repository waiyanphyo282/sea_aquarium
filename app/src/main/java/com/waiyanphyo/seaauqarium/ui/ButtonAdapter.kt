package com.waiyanphyo.seaauqarium.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.waiyanphyo.seaauqarium.data.Button
import com.waiyanphyo.seaauqarium.databinding.ItemButtonBinding

class ButtonAdapter(private val context: Context): ListAdapter<Button, ButtonAdapter.ButtonViewHolder>(Diff) {

    object Diff: DiffUtil.ItemCallback<Button>() {
        override fun areItemsTheSame(oldItem: Button, newItem: Button): Boolean {
            return oldItem.buttonText == newItem.buttonText
        }

        override fun areContentsTheSame(oldItem: Button, newItem: Button): Boolean {
            return oldItem == newItem
        }

    }

    inner class ButtonViewHolder(private val binding: ItemButtonBinding): ViewHolder(binding.root) {
        fun bindData(button: Button) {
            binding.ivButton.setImageDrawable(ResourcesCompat.getDrawable(context.resources, button.iconId, null))
            binding.tvButton.text = button.buttonText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val binding = ItemButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ButtonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}