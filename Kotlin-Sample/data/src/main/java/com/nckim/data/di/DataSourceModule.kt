package com.nckim.data.di

import com.nckim.data.api.PicsumInterface
import com.nckim.data.repository.datasource.ImageRemoteDataSource
import com.nckim.data.repository.datasource.ImageRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideImageRemoteDataSource(picsumInterface: PicsumInterface): ImageRemoteDataSource{
        return ImageRemoteDataSourceImpl(picsumInterface)
    }
}