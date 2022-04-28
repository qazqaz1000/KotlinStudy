package com.nckim.kotlin_sample.views.base

import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel(){

    private val job = Job()

    val viewModelScoped = CoroutineScope(Dispatchers.Main + job)

    override fun onCleared() {
        super.onCleared()

        job.cancel()
    }
}