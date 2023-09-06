package com.mohammadhashem.repository.crypto.di

import com.mohammadhashem.domain.repository.RepositoryCC
import com.mohammadhashem.domain.repository.RepositoryLogo
import com.mohammadhashem.domain.repository.dao.CryptoDao
import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.network.sources.cryptocurrencies.DataSourceRemote
import com.mohammadhashem.network.sources.cryptocurrencies.DataSourceRemoteImpl
import com.mohammadhashem.network.sources.logo.DataSourceRemoteLogo
import com.mohammadhashem.network.sources.logo.DataSourceRemoteLogoImpl
import com.mohammadhashem.repository.crypto.RepositoryCCImpl
import com.mohammadhashem.repository.crypto.RepositoryLogoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvideDataSource {

//Don't need @Inject Annotation


    @Singleton
    @Provides
    fun provideDataSourceRemote(api: ApiCrypto): DataSourceRemote = DataSourceRemoteImpl(api)

    @Singleton
    @Provides
    fun provideDataSourceRemoteLogo(api: ApiCrypto): DataSourceRemoteLogo = DataSourceRemoteLogoImpl(api)


        @Singleton
    @Provides
    fun provideRepositoryNetwork(dataSourceRemote: DataSourceRemote,dataSourceCache: CryptoDao): RepositoryCC =
        RepositoryCCImpl(dataSourceRemote,dataSourceCache)

    @Singleton
    @Provides
    fun provideRepositoryNetworkLogo(dataSourceRemote: DataSourceRemoteLogo): RepositoryLogo =
        RepositoryLogoImpl(dataSourceRemote)
}