package com.nckim.kotlin_sample.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nckim.domain.model.ImageModel
import com.nckim.kotlin_sample.databinding.ItemImageVerticalBinding

class ImageVerticalViewHolder(private val binding: ItemImageVerticalBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ImageModel, listener: (ImageModel, Int) -> Unit){
        itemView.setOnClickListener{ listener(item, layoutPosition) }

        binding.image = item

        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ImageVerticalViewHolder {
            val binding = ItemImageVerticalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return ImageVerticalViewHolder(binding)
        }
    }
}