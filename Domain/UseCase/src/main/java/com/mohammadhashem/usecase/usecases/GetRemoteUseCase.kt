package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.network.repository.cryptocurrencies.RepositoryNetwork
import com.mohammadhashem.utils.ResultData


class GetRemoteUseCase(
    private val repositoryNetwork: RepositoryNetwork,
) {
    suspend operator fun invoke(
        start:Int,
        limit: Int,
        sort: String,
        sort_type: String,
        volume24_min: Double,
        volume24_max: Double,
        percent_change24_min: Double,
        percent_change24_max: Double,

    ): CryptoResponse =
        repositoryNetwork.getAllCryptoCurrencies(
            start,
            limit,
            sort,
            sort_type,
            volume24_min,
            volume24_max,
            percent_change24_min,
            percent_change24_max,

        )
}