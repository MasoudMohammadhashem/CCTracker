package com.mohammadhashem.cache.repository.datasource

import com.mohammadhashem.cache.model.CryptoModel
import kotlinx.coroutines.flow.Flow


interface DataSourceCache {
    fun getCacheData(): List<CryptoModel>
    fun insertCacheData(cryptoModel: CryptoModel):Long
}