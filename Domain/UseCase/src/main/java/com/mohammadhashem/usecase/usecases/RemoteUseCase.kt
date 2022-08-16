package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.model.remote.response.CryptoResponse
import com.mohammadhashem.usecase.repository.RepositoryCC


class RemoteUseCase(
    private val repositoryNetwork: RepositoryCC,
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