package com.mohammadhashem.network.repository.cryptocurrencies.source

import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.utils.ResultData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSourceRemoteImpl @Inject constructor(private val api: ApiCrypto): DataSourceRemote {
    override suspend fun getCryptoCurrencies(
        limit: Int,
        sort: String,
        sort_type: String,
        percent_change24_min: Double,
        percent_change24_max: Double,
        volume24_min: Double,
        volume24_max: Double
    ): CryptoResponse = api.getAllCurrencies(limit,sort,sort_type,percent_change24_min,percent_change24_max,volume24_min,volume24_max)
}