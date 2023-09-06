package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.domain.model.remote.response.CryptoResponse
import com.mohammadhashem.domain.repository.RepositoryCC


class RemoteUseCase(
    private val repositoryNetwork: com.mohammadhashem.domain.repository.RepositoryCC,
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

    ): com.mohammadhashem.domain.model.remote.response.CryptoResponse =
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