package com.nckim.kotlin_sample.views.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nckim.kotlin_sample.views.screen.MainViewModel

abstract class BaseFragment <B: ViewDataBinding>(@LayoutRes val layoutId: Int) : Fragment() {

    private var _binding: B? = null

    val binding get() = _binding!!

    val viewModel: MainViewModel by activityViewModels()

    lateinit var navController: NavController

    private lateinit var callback: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackButtonPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initializeViews()

        initializeListener()

        observeViewModels()
    }

    abstract fun initializeViews()

    abstract fun initializeListener()

    abstract fun observeViewModels()

    abstract fun onBackButtonPressed()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

}