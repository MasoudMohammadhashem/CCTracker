package com.mohammadhashem.network.sources.cryptocurrencies

import com.mohammadhashem.domain.model.remote.response.CryptoResponse

interface DataSourceRemote {
    suspend fun getCryptoCurrencies(
        start:Int,
        limit: Int,
        sort: String, sort_type: String,
        percent_change24_min: Double,
        percent_change24_max: Double,
        volume24_min: Double, volume24_max: Double
    ): com.mohammadhashem.domain.model.remote.response.CryptoResponse
}