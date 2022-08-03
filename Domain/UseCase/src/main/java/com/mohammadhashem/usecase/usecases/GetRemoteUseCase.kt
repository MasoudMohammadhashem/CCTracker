package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.network.repository.cryptocurrencies.RepositoryNetwork
import com.mohammadhashem.utils.ResultData


class GetRemoteUseCase(
    private val repositoryNetwork: RepositoryNetwork,
) {
    suspend operator fun invoke(
        limit: Int,
        sort: String,
        sort_type: String,
        percent_change24_min: Double,
        percent_change24_max: Double,
        volume24_min: Double,
        volume24_max: Double
    ): CryptoResponse =
        repositoryNetwork.getAllCryptoCurrencies(
            limit,
            sort,
            sort_type,
            percent_change24_min,
            percent_change24_max,
            volume24_min,
            volume24_max
        )
}