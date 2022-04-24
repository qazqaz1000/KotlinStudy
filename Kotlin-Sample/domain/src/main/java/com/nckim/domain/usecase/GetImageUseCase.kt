package com.nckim.domain.usecase

import com.nckim.domain.repository.ImageRepository

class GetImageUseCase (private val imageRepository: ImageRepository){

    suspend fun invoke() = imageRepository.getImage()
}