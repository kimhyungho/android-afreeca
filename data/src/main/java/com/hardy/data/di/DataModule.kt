package com.hardy.data.di

import com.hardy.data.BroadCategoryRepositoryImpl
import com.hardy.data.BroadRepositoryImpl
import com.hardy.data.remote.model.response.GetBroadCategoryResponse
import com.hardy.domain.repositories.BroadCategoryRepository
import com.hardy.domain.repositories.BroadRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Singleton
    @Binds
    fun bindBroadRepository(
        repo: BroadRepositoryImpl
    ): BroadRepository

    @Singleton
    @Binds
    fun bindBroadCategoryRepository(
        repo: BroadCategoryRepositoryImpl
    ): BroadCategoryRepository
}