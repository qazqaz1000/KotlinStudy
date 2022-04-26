package com.nckim.kotlin_sample.views.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.nckim.kotlin_sample.R

class SkeletonItemVerticalView constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    init{
        inflate(context, R.layout.skeleton_item_image_vertical, this)
    }

}