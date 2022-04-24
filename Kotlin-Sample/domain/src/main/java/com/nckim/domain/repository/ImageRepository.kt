package com.nckim.domain.repository

import com.nckim.domain.model.ImageModel

interface ImageRepository {

    suspend fun getImage() : List<ImageModel>
}