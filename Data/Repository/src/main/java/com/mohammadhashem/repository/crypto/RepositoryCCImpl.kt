package com.mohammadhashem.repository.crypto


import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.model.remote.response.CryptoResponse
import com.mohammadhashem.domain.repository.RepositoryCC
import com.mohammadhashem.domain.repository.dao.CryptoDao
import com.mohammadhashem.network.sources.cryptocurrencies.DataSourceRemote
import kotlinx.coroutines.flow.Flow

class RepositoryCCImpl (
    private val remote: DataSourceRemote,
    private val dao: CryptoDao
) : RepositoryCC {
    override fun getAllCache(): Flow<List<CryptoModel>> {
        return dao.getAll()
    }
    override suspend fun insertCache(cryptoModel: CryptoModel) =
        dao.insert(cryptoModel)

    override suspend fun deleteAll() = dao.deleteAll()

    override suspend fun getAllCryptoCurrencies(
        start: Int,
        limit: Int,
        sort: String,
        sort_type: String,
        volume24_min: Double,
        volume24_max: Double,
        percent_change24_min: Double,
        percent_change24_max: Double,
    ): CryptoResponse = remote.getCryptoCurrencies(
        start,
        limit,
        sort,
        sort_type,
        volume24_min,
        volume24_max,
        percent_change24_min,
        percent_change24_max
    )
}