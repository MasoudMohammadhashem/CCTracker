package com.mohammadhashem.cache.sources

import com.mohammadhashem.cache.database.CryptoDataBase
import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.repository.dao.CryptoDao
import kotlinx.coroutines.flow.Flow

class RepositoryCacheImpl (private val db : CryptoDataBase) : CryptoDao() {
    override fun getAll(): Flow<List<CryptoModel>> = db.cryptoCurrenciesDao().getAll()
    override suspend fun insert(cryptoModel: CryptoModel): Long = db.cryptoCurrenciesDao().insert(cryptoModel)
    override suspend fun update(cryptoModel: CryptoModel) {
        TODO("Not yet implemented")
    }
    override suspend fun delete(cryptoModel: CryptoModel) {
        TODO("Not yet implemented")
    }
    override suspend fun deleteAll() = db.cryptoCurrenciesDao().deleteAll()
}