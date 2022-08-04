package com.mohammadhashem.network.repository.cryptocurrencies.source

import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.utils.ResultData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSourceRemoteImpl @Inject constructor(private val api: ApiCrypto): DataSourceRemote {
    override suspend fun getCryptoCurrencies(
        start:Int,
        limit: Int,
        sort: String,
        sort_type: String,
        volume24_min: Double,
        volume24_max: Double,
        percent_change24_min: Double,
        percent_change24_max: Double,
    ): CryptoResponse = api.getAllCurrencies(start,limit,sort,sort_type,volume24_min,volume24_max,percent_change24_min,percent_change24_max)
}