package com.mohammadhashem.cache.repository

import com.mohammadhashem.cache.model.CryptoModel
import com.mohammadhashem.cache.repository.datasource.DataSourceCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryDataBaseImpl @Inject constructor(private val dataSourceCache: DataSourceCache):
    RepositoryDataBase {
    override fun getAllCache(): List<CryptoModel> = dataSourceCache.getCacheData()
    override fun insertCache(cryptoModel: CryptoModel) = dataSourceCache.insertCacheData(cryptoModel)
}