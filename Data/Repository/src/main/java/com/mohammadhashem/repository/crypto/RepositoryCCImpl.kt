package com.mohammadhashem.repository.crypto


import com.mohammadhashem.cache.sources.DataSourceCache
import com.mohammadhashem.network.sources.cryptocurrencies.DataSourceRemote
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.remote.response.CryptoResponse
import com.mohammadhashem.usecase.repository.RepositoryCC
import javax.inject.Inject

class RepositoryCCImpl (
    private val remote: DataSourceRemote,
    private val dataSourceCache: DataSourceCache
) : RepositoryCC {
    override suspend fun getAllCache(): List<CryptoModel> = dataSourceCache.getCacheData()
    override suspend fun insertCache(cryptoModel: CryptoModel) =
        dataSourceCache.insertCacheData(cryptoModel)

    override suspend fun deleteAll() = dataSourceCache.deleteAll()

    override suspend fun getAllCryptoCurrencies(
        start: Int,
        limit: Int,
        sort: String,
        sort_type: String,
        volume24_min: Double,
        volume24_max: Double,
        percent_change24_min: Double,
        percent_change24_max: Double,
    ): CryptoResponse = remote.getCryptoCurrencies(
        start,
        limit,
        sort,
        sort_type,
        volume24_min,
        volume24_max,
        percent_change24_min,
        percent_change24_max
    )
}