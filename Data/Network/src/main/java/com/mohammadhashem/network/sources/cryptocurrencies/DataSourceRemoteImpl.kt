package com.mohammadhashem.network.sources.cryptocurrencies

import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.usecase.model.remote.response.CryptoResponse
import javax.inject.Singleton

@Singleton
class DataSourceRemoteImpl (private val api: ApiCrypto): DataSourceRemote {
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