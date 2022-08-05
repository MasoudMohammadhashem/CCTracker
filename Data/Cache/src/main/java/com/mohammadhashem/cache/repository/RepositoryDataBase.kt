package com.mohammadhashem.cache.repository

import com.mohammadhashem.cache.model.CryptoModel
import kotlinx.coroutines.flow.Flow

interface RepositoryDataBase {
    suspend fun getAllCache(): List<CryptoModel>
    suspend fun insertCache(cryptoModel: CryptoModel):Long
    suspend fun deleteAll()
}