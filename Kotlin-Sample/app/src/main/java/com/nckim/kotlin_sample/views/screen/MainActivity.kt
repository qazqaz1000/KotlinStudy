package com.nckim.kotlin_sample.views.screen

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.nckim.kotlin_sample.R
import com.nckim.kotlin_sample.databinding.ActivityMainBinding
import com.nckim.kotlin_sample.utils.KeepStateNavigator
import com.nckim.kotlin_sample.views.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.findNavController()

        /** KeepStateNavigator navController에 추가 */
        val navigator = KeepStateNavigator(this , navHostFragment.childFragmentManager, R.id.nav_host_fragment_container)
        navController.navigatorProvider.addNavigator(navigator)
        navController.setGraph(R.navigation.nav_graph)
    }
}