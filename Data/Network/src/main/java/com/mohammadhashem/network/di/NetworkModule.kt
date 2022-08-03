package com.mohammadhashem.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.network.repository.cryptocurrencies.source.DataSourceRemote
import com.mohammadhashem.network.repository.cryptocurrencies.source.DataSourceRemoteImpl
import com.mohammadhashem.network.repository.logourl.source.DataSourceRemoteLogo
import com.mohammadhashem.network.repository.logourl.source.DataSourceRemoteLogoImpl
import com.mohammadhashem.utils.constval.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provide() :Gson{
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideCryptoApi():ApiCrypto{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCrypto::class.java)
    }
    @Singleton
    @Provides
    fun provideDataSourceRemote(api:ApiCrypto): DataSourceRemote = DataSourceRemoteImpl(api)

    @Singleton
    @Provides
    fun provideDataSourceRemoteLogo(api:ApiCrypto): DataSourceRemoteLogo = DataSourceRemoteLogoImpl(api)
}