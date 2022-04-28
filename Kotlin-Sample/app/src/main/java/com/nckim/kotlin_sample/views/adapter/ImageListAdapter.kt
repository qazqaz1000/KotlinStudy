package com.nckim.kotlin_sample.views.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nckim.domain.model.ImageModel
import com.nckim.kotlin_sample.views.adapter.base.BaseViewHolder

class ImageListAdapter: ListAdapter<ImageModel, BaseViewHolder>(diffUtil){

    internal var clickListener: (ImageModel, Int) -> Unit = { _, _ -> }

    lateinit var type: ImageViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(type){
            ImageViewHolder.ImageList -> ImageVerticalViewHolder.from(parent)
            ImageViewHolder.ImageDetail -> ImageDetailViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
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

    sealed class ImageViewHolder {
        object ImageList : ImageViewHolder()
        object ImageDetail : ImageViewHolder()
    }
}