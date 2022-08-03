package com.mohammadhashem.network.di

import com.mohammadhashem.network.repository.cryptocurrencies.RepositoryNetwork
import com.mohammadhashem.network.repository.cryptocurrencies.RepositoryNetworkImpl
import com.mohammadhashem.network.repository.cryptocurrencies.source.DataSourceRemote
import com.mohammadhashem.network.repository.logourl.RepositoryLogo
import com.mohammadhashem.network.repository.logourl.RepositoryLogoImpl
import com.mohammadhashem.network.repository.logourl.source.DataSourceRemoteLogo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepositoryNetwork(dataSourceRemote: RepositoryNetworkImpl): RepositoryNetwork

    @Singleton
    @Binds
    abstract fun bindRepositoryNetworkLogo(dataSourceRemote: RepositoryLogoImpl): RepositoryLogo
}