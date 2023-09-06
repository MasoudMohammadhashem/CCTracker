package com.mohammadhashem.repository

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mohammadhashem.cache.database.CryptoDataBase
import com.mohammadhashem.cache.sources.RepositoryCacheImpl
import com.mohammadhashem.domain.repository.dao.CryptoDao
import com.mohammadhashem.network.api.ApiCrypto
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
object CommonModules {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, CryptoDataBase::class.java, "CryptoDataBase"
    ).fallbackToDestructiveMigration().build()
    @Singleton
    @Provides
    fun provideDataSourceCache(db: CryptoDataBase): CryptoDao = RepositoryCacheImpl(db)
    @Singleton
    @Provides
    fun provide(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideCryptoApi(): ApiCrypto {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCrypto::class.java)
    }
}