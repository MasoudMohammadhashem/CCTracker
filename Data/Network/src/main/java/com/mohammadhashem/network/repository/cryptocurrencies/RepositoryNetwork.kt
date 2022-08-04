package com.mohammadhashem.network.repository.cryptocurrencies

import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.utils.ResultData

interface RepositoryNetwork {
    suspend fun getAllCryptoCurrencies(
        start:Int,limit:Int,sort:String,sort_type:String,
        volume24_min:Double,volume24_max: Double,
                               percent_change24_min:Double,
                               percent_change24_max:Double,
                               ): CryptoResponse
}