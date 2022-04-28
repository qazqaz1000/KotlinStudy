package com.nckim.kotlin_sample.views.adapter.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nckim.domain.model.ImageModel

open class BaseViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(item: ImageModel, listener: (ImageModel, Int) -> Unit) {}


    companion object {
        fun from(parent: ViewGroup): BaseViewHolder {
            return BaseViewHolder(parent)
        }
    }
}