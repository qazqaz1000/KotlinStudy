package com.nckim.kotlin_sample.views.screen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nckim.kotlin_sample.R
import com.nckim.kotlin_sample.databinding.ActivityNckimMainBinding
import com.nckim.kotlin_sample.views.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NckimMainActivity : BaseActivity<ActivityNckimMainBinding>(R.layout.activity_nckim_main) {

    private val viewModel: NckimMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.requestImage()
    }
}