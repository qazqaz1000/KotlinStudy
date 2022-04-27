package com.nckim.kotlin_sample.views.screen

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.nckim.kotlin_sample.R
import com.nckim.kotlin_sample.databinding.FragmentMainBinding
import com.nckim.kotlin_sample.utils.setupActionBar
import com.nckim.kotlin_sample.views.base.BaseFragment


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun initializeViews() {
        (activity as AppCompatActivity).setupActionBar(R.id.toolbar){
            setHasOptionsMenu(true)                     //onOptionsItemSelected callback을 받기위해 필요
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun initializeListener() {
        binding.btImageList.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToImageListFragment()
            navController.navigate(action)
        }
    }

    override fun observeViewModels() {

    }

    override fun onBackButtonPressed() {

    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // Open the navigation drawer when the home icon is selected from the toolbar.
                binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}