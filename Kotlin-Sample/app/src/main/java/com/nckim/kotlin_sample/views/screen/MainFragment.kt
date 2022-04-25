package com.nckim.kotlin_sample.views.screen


import android.os.Bundle
import android.view.View
import com.nckim.kotlin_sample.R
import com.nckim.kotlin_sample.databinding.FragmentMainBinding
import com.nckim.kotlin_sample.views.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun initializeViews() {

    }

    override fun initializeListener() {
        binding.btImageList.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToImageListFragment()
            navController.navigate(action)
        }
    }

    override fun observeViewModels() {

    }
}