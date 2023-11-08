package com.waiyanphyo.seaauqarium.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.waiyanphyo.seaauqarium.data.UpcomingShow
import com.waiyanphyo.seaauqarium.databinding.ItemUpcomingShowBinding

class UpcomingShowAdapter(val context: Context): ListAdapter<UpcomingShow, UpcomingShowAdapter.UpcomingShowViewHolder>(Diff) {

    private var onItemClickListener: ((UpcomingShow) -> Unit)? = null

    fun setOnItemClickListener(listener: (UpcomingShow) -> Unit) {
        onItemClickListener = listener
    }

    object Diff: DiffUtil.ItemCallback<UpcomingShow>() {
        override fun areItemsTheSame(oldItem: UpcomingShow, newItem: UpcomingShow): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: UpcomingShow, newItem: UpcomingShow): Boolean {
            return oldItem == newItem
        }

    }

    inner class UpcomingShowViewHolder(private val binding: ItemUpcomingShowBinding): ViewHolder(binding.root) {

        fun bindData(upcomingShow: UpcomingShow) {
            with(binding) {
                root.setOnClickListener {
                    onItemClickListener?.invoke(upcomingShow)
                }
                tvTitle.text = upcomingShow.title
                tvTime.text = upcomingShow.time
                ivImage.setImageDrawable(ResourcesCompat.getDrawable(context.resources, upcomingShow.image, null))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingShowViewHolder {
        val binding = ItemUpcomingShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingShowViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}