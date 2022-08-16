package com.mohammadhashem.cache.sources

import com.mohammadhashem.cache.database.CryptoDataBase
import com.mohammadhashem.usecase.model.CryptoModel

import javax.inject.Inject

class DataSourceCacheImpl (private val db : CryptoDataBase) : DataSourceCache {
    override suspend fun getCacheData(): List<CryptoModel> = db.cryptoCurrenciesDao().getAll()
    override suspend fun insertCacheData(cryptoModel: CryptoModel): Long = db.cryptoCurrenciesDao().insert(cryptoModel)
    override suspend fun deleteAll() = db.cryptoCurrenciesDao().deleteAll()
}