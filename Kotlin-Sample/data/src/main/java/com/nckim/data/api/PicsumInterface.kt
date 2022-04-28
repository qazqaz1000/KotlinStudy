package com.nckim.data.api

import com.nckim.data.api.ApiClient.PICSUM_BASE_URL
import com.nckim.domain.model.ImageModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumInterface {

    @GET("/v2/list/")
    suspend fun getImage(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<ImageModel>

    companion object{
        fun createPicsumAPI(): PicsumInterface {
            val logger = HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(PICSUM_BASE_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PicsumInterface::class.java)
        }
    }
}