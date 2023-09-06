package com.mohammadhashem.domain.repository

import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.model.remote.response.CryptoResponse
import kotlinx.coroutines.flow.Flow

interface RepositoryCC {
    fun getAllCache(): Flow<List<CryptoModel>>
    suspend fun insertCache(cryptoModel: CryptoModel):Long
    suspend fun deleteAll()
    suspend fun getAllCryptoCurrencies(
        start:Int,limit:Int,sort:String,sort_type:String,
        volume24_min:Double,volume24_max: Double,
        percent_change24_min:Double,
        percent_change24_max:Double,
    ): CryptoResponse
}