package com.nckim.kotlin_sample.views.screen

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nckim.kotlin_sample.R
import com.nckim.kotlin_sample.databinding.FragmentImageListBinding
import com.nckim.kotlin_sample.views.adapter.ImageListAdapter
import com.nckim.kotlin_sample.views.base.BaseFragment


class ImageListFragment : BaseFragment<FragmentImageListBinding>(R.layout.fragment_image_list){

    private val imageListAdapter = ImageListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

    }

    override fun initializeViews(){
        binding.recyclerView.adapter = imageListAdapter

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun observeViewModels(){
        viewModel.images.observe(viewLifecycleOwner) { images ->
            println("gg : $images")
        }

//        viewModel.navigateToDetailIndex.observe(viewLifecycleOwner){
//            val action = ImageListFragmentDirections.actionImageListFragmentToImageDetailFragment(index = it)
//            navController.navigate(action)
//        }
    }

    override fun initializeListener() {
        binding.button.setOnClickListener {
            viewModel.requestImage()
        }

        imageListAdapter.clickListener = {imageModel, position ->
            println(imageModel.toString())
            println(position)
            viewModel.onImageItemClick(imageModel, position)
            val action = ImageListFragmentDirections.actionImageListFragmentToImageDetailFragment(position)
            navController.navigate(action)
        }
    }

    override fun onBackButtonPressed() {
        val action = ImageListFragmentDirections.actionImageListFragmentToMainFragment()
        navController.navigate(action)
    }
}