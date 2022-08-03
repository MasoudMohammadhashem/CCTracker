package com.mohammadhashem.usecase.di

import com.mohammadhashem.cache.repository.RepositoryDataBase
import com.mohammadhashem.network.repository.cryptocurrencies.RepositoryNetwork
import com.mohammadhashem.network.repository.logourl.RepositoryLogo
import com.mohammadhashem.usecase.usecases.*
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
    fun provideUseCases (repositoryNetwork: RepositoryNetwork,
                         repositoryDataBase: RepositoryDataBase,
                         repositoryLogo: RepositoryLogo
    )= AllUseCases(
        GetRemoteUseCase(repositoryNetwork),
        GetCacheUseCase(repositoryDataBase),
        InsertCacheUseCase(repositoryDataBase),
        GetLogoUseCase(repositoryLogo)
    )
}