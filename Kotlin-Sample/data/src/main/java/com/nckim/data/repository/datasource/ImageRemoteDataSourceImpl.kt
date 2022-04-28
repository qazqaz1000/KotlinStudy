package com.nckim.data.repository.datasource

import com.nckim.data.api.PicsumInterface
import com.nckim.domain.model.ImageModel
import javax.inject.Inject

class ImageRemoteDataSourceImpl @Inject constructor(private val picsumInterface: PicsumInterface) : ImageRemoteDataSource {

    override suspend fun getImage(): List<ImageModel> {
        return picsumInterface.getImage(1, 20)
    }
}