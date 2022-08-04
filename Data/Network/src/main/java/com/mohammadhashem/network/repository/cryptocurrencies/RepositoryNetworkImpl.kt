package com.mohammadhashem.network.repository.cryptocurrencies

import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.network.repository.cryptocurrencies.source.DataSourceRemote
import com.mohammadhashem.utils.ResultData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryNetworkImpl @Inject constructor (private val remote: DataSourceRemote):
    RepositoryNetwork {
    override suspend fun getAllCryptoCurrencies(
        start:Int,
        limit:Int,
        sort: String,
        sort_type: String,
        volume24_min: Double,
        volume24_max: Double,
        percent_change24_min: Double,
        percent_change24_max: Double,

    ): CryptoResponse = remote.getCryptoCurrencies(start,limit,sort,sort_type,volume24_min,volume24_max,percent_change24_min,percent_change24_max)
}