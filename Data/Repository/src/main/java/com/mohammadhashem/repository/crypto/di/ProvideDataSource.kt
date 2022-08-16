package com.mohammadhashem.repository.crypto.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mohammadhashem.cache.database.CryptoDataBase
import com.mohammadhashem.cache.sources.DataSourceCache
import com.mohammadhashem.cache.sources.DataSourceCacheImpl
import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.network.sources.cryptocurrencies.DataSourceRemote
import com.mohammadhashem.network.sources.cryptocurrencies.DataSourceRemoteImpl
import com.mohammadhashem.network.sources.logo.DataSourceRemoteLogo
import com.mohammadhashem.network.sources.logo.DataSourceRemoteLogoImpl
import com.mohammadhashem.repository.crypto.RepositoryCCImpl
import com.mohammadhashem.repository.crypto.RepositoryLogoImpl
import com.mohammadhashem.usecase.repository.RepositoryCC
import com.mohammadhashem.usecase.repository.RepositoryLogo
import com.mohammadhashem.usecase.usecases.*
import com.mohammadhashem.utils.constval.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvideDataSource {

//Don't need @Inject Annotation
    @Singleton
    @Provides
    fun provideDataSourceCache(db: CryptoDataBase): DataSourceCache = DataSourceCacheImpl(db)

    @Singleton
    @Provides
    fun provideDataSourceRemote(api: ApiCrypto): DataSourceRemote = DataSourceRemoteImpl(api)

    @Singleton
    @Provides
    fun provideDataSourceRemoteLogo(api: ApiCrypto): DataSourceRemoteLogo = DataSourceRemoteLogoImpl(api)


        @Singleton
    @Provides
    fun provideRepositoryNetwork(dataSourceRemote: DataSourceRemote,dataSourceCache: DataSourceCache): RepositoryCC =
        RepositoryCCImpl(dataSourceRemote,dataSourceCache)

    @Singleton
    @Provides
    fun provideRepositoryNetworkLogo(dataSourceRemote: DataSourceRemoteLogo): RepositoryLogo =
        RepositoryLogoImpl(dataSourceRemote)
}