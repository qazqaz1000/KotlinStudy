package com.nckim.kotlin_sample.views.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nckim.kotlin_sample.R

abstract class BaseActivity <B: ViewDataBinding> (@LayoutRes private val id: Int) : AppCompatActivity() {

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, id)
        binding.lifecycleOwner = this
    }
}