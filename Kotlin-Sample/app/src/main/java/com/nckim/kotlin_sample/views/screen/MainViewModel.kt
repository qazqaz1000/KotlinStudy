package com.nckim.kotlin_sample.views.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nckim.domain.model.ImageModel
import com.nckim.domain.usecase.GetImageUseCase
import com.nckim.kotlin_sample.views.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase
) : BaseViewModel() {

    //Images
    private var _images = MutableLiveData<List<ImageModel>>()
    val images: LiveData<List<ImageModel>> = _images

    //Image Skeleton
    private var _isImageLoading = MutableLiveData(false)
    val isImageLoading: LiveData<Boolean> = _isImageLoading

    fun requestImage(){
        viewModelScoped.launch {
            _isImageLoading.value = true
            val list = getImageUseCase.invoke()
            _isImageLoading.value = false
            println(list.toString())

            _images.value = list
        }
    }
}