package com.mohammadhashem.cache.repository.datasource

import com.mohammadhashem.cache.model.CryptoModel
import kotlinx.coroutines.flow.Flow


interface DataSourceCache {
    suspend fun getCacheData(): List<CryptoModel>
    suspend fun insertCacheData(cryptoModel: CryptoModel):Long
    suspend fun deleteAll()
}