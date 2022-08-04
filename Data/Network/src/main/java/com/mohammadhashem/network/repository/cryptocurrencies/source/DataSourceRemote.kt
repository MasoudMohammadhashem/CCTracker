package com.mohammadhashem.network.repository.cryptocurrencies.source

import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.utils.ResultData

interface DataSourceRemote {
    suspend fun getCryptoCurrencies(
        start:Int,
        limit: Int,
        sort: String, sort_type: String,
        percent_change24_min: Double,
        percent_change24_max: Double,
        volume24_min: Double, volume24_max: Double
    ): CryptoResponse
}