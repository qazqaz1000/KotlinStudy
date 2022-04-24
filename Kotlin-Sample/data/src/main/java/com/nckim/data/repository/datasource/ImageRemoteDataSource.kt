package com.nckim.data.repository.datasource

import com.nckim.domain.model.ImageModel

interface ImageRemoteDataSource {
    suspend fun getImage() : List<ImageModel>
}