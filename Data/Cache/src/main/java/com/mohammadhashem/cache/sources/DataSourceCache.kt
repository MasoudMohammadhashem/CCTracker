package com.mohammadhashem.cache.sources

import com.mohammadhashem.usecase.model.CryptoModel


interface DataSourceCache {
    suspend fun getCacheData(): List<CryptoModel>
    suspend fun insertCacheData(cryptoModel: CryptoModel):Long
    suspend fun deleteAll()
}