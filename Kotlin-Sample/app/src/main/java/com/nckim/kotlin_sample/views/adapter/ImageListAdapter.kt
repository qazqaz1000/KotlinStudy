package com.nckim.kotlin_sample.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nckim.domain.model.ImageModel
import com.nckim.kotlin_sample.databinding.ItemImageVerticalBinding

class ImageListAdapter : ListAdapter<ImageModel, ImageVerticalViewHolder>(diffUtil){

    internal var clickListener: (ImageModel, Int) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVerticalViewHolder {
        return ImageVerticalViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ImageVerticalViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ImageModel>(){
            override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean =
                oldItem == newItem
        }
    }
}