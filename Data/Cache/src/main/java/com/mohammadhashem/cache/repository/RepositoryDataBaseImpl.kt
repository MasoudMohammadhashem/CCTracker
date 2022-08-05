package com.mohammadhashem.cache.repository

import com.mohammadhashem.cache.model.CryptoModel
import com.mohammadhashem.cache.repository.datasource.DataSourceCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryDataBaseImpl @Inject constructor(private val dataSourceCache: DataSourceCache) :
    RepositoryDataBase {
    override suspend fun getAllCache(): List<CryptoModel> = dataSourceCache.getCacheData()
    override suspend fun insertCache(cryptoModel: CryptoModel) = dataSourceCache.insertCacheData(cryptoModel)
    override suspend fun deleteAll() = dataSourceCache.deleteAll()
}