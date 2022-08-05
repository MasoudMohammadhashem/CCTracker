package com.mohammadhashem.cache.repository.datasource

import com.mohammadhashem.cache.database.CryptoDataBase
import com.mohammadhashem.cache.model.CryptoModel
import com.mohammadhashem.cache.repository.datasource.DataSourceCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataSourceCacheImpl @Inject constructor(private val db : CryptoDataBase) : DataSourceCache {
    override suspend fun getCacheData(): List<CryptoModel> = db.cryptoCurrenciesDao().getAll()
    override suspend fun insertCacheData(cryptoModel: CryptoModel): Long = db.cryptoCurrenciesDao().insert(cryptoModel)
    override suspend fun deleteAll() = db.cryptoCurrenciesDao().deleteAll()
}