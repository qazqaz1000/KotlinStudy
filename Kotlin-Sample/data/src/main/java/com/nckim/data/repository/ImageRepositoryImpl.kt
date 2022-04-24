package com.nckim.data.repository

import com.nckim.data.repository.datasource.ImageRemoteDataSource
import com.nckim.domain.model.ImageModel
import com.nckim.domain.repository.ImageRepository

class ImageRepositoryImpl constructor(private val imageRemoteDataSource: ImageRemoteDataSource) : ImageRepository {
    override suspend fun getImage(): List<ImageModel> {
        return imageRemoteDataSource.getImage()
    }
}