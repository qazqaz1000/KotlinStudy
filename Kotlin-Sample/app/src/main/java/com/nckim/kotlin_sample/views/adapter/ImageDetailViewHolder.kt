package com.nckim.kotlin_sample.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nckim.domain.model.ImageModel
import com.nckim.kotlin_sample.databinding.ItemImageDetailBinding
import com.nckim.kotlin_sample.views.adapter.base.BaseViewHolder

class ImageDetailViewHolder(private val binding: ItemImageDetailBinding) : BaseViewHolder(binding.root) {

    override fun bind(item: ImageModel, listener: (ImageModel, Int) -> Unit) {
        binding.imageModel = item

        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ImageDetailViewHolder {
            val binding = ItemImageDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return ImageDetailViewHolder(binding)
        }
    }
}