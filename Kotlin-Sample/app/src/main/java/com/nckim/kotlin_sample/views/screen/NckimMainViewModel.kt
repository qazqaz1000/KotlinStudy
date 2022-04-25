package com.nckim.kotlin_sample.views.screen

import com.nckim.domain.usecase.GetImageUseCase
import com.nckim.kotlin_sample.views.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NckimMainViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase
) : BaseViewModel() {



    fun requestImage(){
        viewModelScoped.launch {
            val list = getImageUseCase.invoke()
            println(list.toString())
        }
    }
}