package com.mohammadhashem.cache.di

import com.mohammadhashem.cache.repository.RepositoryDataBase
import com.mohammadhashem.cache.repository.RepositoryDataBaseImpl
import com.mohammadhashem.cache.repository.datasource.DataSourceCacheImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryCacheModule {

    @Binds
    @Singleton
    fun bindCacheRepository(dataSourceCacheImpl: RepositoryDataBaseImpl): RepositoryDataBase
}