package com.nckim.kotlin_sample.views.screen

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.nckim.kotlin_sample.R
import com.nckim.kotlin_sample.databinding.FragmentImageDetailBinding
import com.nckim.kotlin_sample.views.adapter.ImageListAdapter
import com.nckim.kotlin_sample.views.base.BaseFragment


class ImageDetailFragment : BaseFragment<FragmentImageDetailBinding>(R.layout.fragment_image_detail){

    private val args: ImageDetailFragmentArgs by navArgs()

    private val imageListAdapter = ImageListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageModel = viewModel.navigateToDetailImageModel.value
        binding.viewModel = viewModel
        imageListAdapter.type = ImageListAdapter.ImageViewHolder.ImageDetail
        binding.detailViewpager.adapter = imageListAdapter
    }

    override fun initializeViews() {
    }

    override fun initializeListener() {
    }

    override fun observeViewModels() {
    }

    override fun onBackButtonPressed() {
        val action = ImageDetailFragmentDirections.actionImageDetailFragmentToImageListFragment()
        navController.navigate(R.id.imageListFragment)

//        val nav =  navController.navigatorProvider.getNavigator<KeepStateNavigator>()
//        nav.navigate(nav.createDestination(), null, null, null)
//        println(navController.navigatorProvider.navigators.toString())
    }
}