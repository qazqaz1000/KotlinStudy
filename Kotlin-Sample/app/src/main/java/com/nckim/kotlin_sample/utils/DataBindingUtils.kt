package com.nckim.kotlin_sample.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.nckim.domain.model.ImageModel
import com.nckim.kotlin_sample.R
import com.nckim.kotlin_sample.views.adapter.ImageListAdapter


@BindingAdapter("url")
fun bindImage(imageView: ImageView, url: String){
    Glide.with(imageView)
        .load(url)
        .placeholder(R.drawable.ic_default)
        .into(imageView)
}

@BindingAdapter("setItems")
fun setItems(recyclerView: RecyclerView, items: List<ImageModel>?){
    items?.let {
        (recyclerView.adapter as ImageListAdapter).submitList(it)
    }
}

@BindingAdapter("setItems")
fun setItems(viewPager2: ViewPager2, items: List<ImageModel>?){
    items?.let {
        (viewPager2.adapter as ImageListAdapter).submitList(it)
    }
}

@BindingAdapter("imageW", "imageH")
fun setTextWxH(textView: TextView, width: Int, height: Int){
    textView.text = "$width x $height"
}