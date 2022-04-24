package com.nckim.data.api

import com.nckim.domain.model.ImageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumInterface {

    @GET("/v2/list/")
    suspend fun getImage(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<ImageModel>
}