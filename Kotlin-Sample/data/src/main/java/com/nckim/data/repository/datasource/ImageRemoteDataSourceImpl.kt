package com.nckim.data.repository.datasource

import com.nckim.data.api.PicsumInterface
import com.nckim.domain.model.ImageModel

class ImageRemoteDataSourceImpl constructor(private val picsumInterface: PicsumInterface) : ImageRemoteDataSource {
    override suspend fun getImage(): List<ImageModel> {
        return picsumInterface.getImage(1, 20)
    }
}