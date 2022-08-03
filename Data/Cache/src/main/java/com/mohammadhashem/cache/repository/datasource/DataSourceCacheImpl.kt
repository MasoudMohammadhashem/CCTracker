package com.mohammadhashem.cache.repository.datasource

import com.mohammadhashem.cache.database.CryptoDataBase
import com.mohammadhashem.cache.model.CryptoModel
import com.mohammadhashem.cache.repository.datasource.DataSourceCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataSourceCacheImpl @Inject constructor(private val db : CryptoDataBase) : DataSourceCache {
    override fun getCacheData(): List<CryptoModel> = db.ProductDao().getAll()
    override fun insertCacheData(cryptoModel: CryptoModel): Long = db.ProductDao().insert(cryptoModel)
}