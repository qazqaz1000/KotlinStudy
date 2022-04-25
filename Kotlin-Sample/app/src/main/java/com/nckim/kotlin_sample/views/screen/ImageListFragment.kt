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
        viewModel.requestImage()
    }

    override fun initializeViews(){
        binding.recyclerView.adapter = imageListAdapter

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun observeViewModels(){
        viewModel.images.observe(viewLifecycleOwner) { images ->
            println("gg : $images")
        }
    }

    override fun initializeListener() {
        imageListAdapter.clickListener = {imageModel, i ->
            println(imageModel.toString())
            println(i)
        }
    }
}