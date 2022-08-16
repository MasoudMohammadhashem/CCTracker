package com.mohammadhashem.usecase.repository

import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.remote.response.CryptoResponse

interface RepositoryCC {
    suspend fun getAllCache(): List<CryptoModel>
    suspend fun insertCache(cryptoModel: CryptoModel):Long
    suspend fun deleteAll()
    suspend fun getAllCryptoCurrencies(
        start:Int,limit:Int,sort:String,sort_type:String,
        volume24_min:Double,volume24_max: Double,
        percent_change24_min:Double,
        percent_change24_max:Double,
    ): CryptoResponse
}