package com.mohammadhashem.cache.di

import android.content.Context
import androidx.room.Room
import com.mohammadhashem.cache.database.CryptoDataBase
import com.mohammadhashem.cache.repository.datasource.DataSourceCache
import com.mohammadhashem.cache.repository.datasource.DataSourceCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, CryptoDataBase::class.java,"CryptoDataBase"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDataSourceCache(db: CryptoDataBase): DataSourceCache = DataSourceCacheImpl(db)
}