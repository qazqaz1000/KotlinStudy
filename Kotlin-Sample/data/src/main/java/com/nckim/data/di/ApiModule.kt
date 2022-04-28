package com.nckim.data.di

import com.nckim.data.api.PicsumInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun providePicsumInterface(): PicsumInterface{
        return PicsumInterface.createPicsumAPI()
    }
}