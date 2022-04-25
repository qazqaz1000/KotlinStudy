package com.nckim.domain.usecase

import com.nckim.domain.repository.ImageRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val imageRepository: ImageRepository) {

    suspend fun invoke() = imageRepository.getImage()
}