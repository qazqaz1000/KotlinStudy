package com.nckim.data.di

import com.nckim.data.repository.ImageRepositoryImpl
import com.nckim.data.repository.datasource.ImageRemoteDataSource
import com.nckim.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideImageRepository(imageRemoteDataSource: ImageRemoteDataSource): ImageRepository{
        return ImageRepositoryImpl(imageRemoteDataSource)
    }
}