package com.nckim.domain.di

import com.nckim.domain.repository.ImageRepository
import com.nckim.domain.usecase.GetImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetImageUseCase(imageRepository: ImageRepository): GetImageUseCase{
        return GetImageUseCase(imageRepository)
    }
}