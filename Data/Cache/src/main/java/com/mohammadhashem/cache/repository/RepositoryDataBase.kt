package com.mohammadhashem.cache.repository

import com.mohammadhashem.cache.model.CryptoModel
import kotlinx.coroutines.flow.Flow

interface RepositoryDataBase {
    fun getAllCache(): List<CryptoModel>
    fun insertCache(cryptoModel: CryptoModel):Long
}