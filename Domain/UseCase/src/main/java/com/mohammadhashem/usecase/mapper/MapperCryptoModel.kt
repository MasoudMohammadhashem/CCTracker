package com.mohammadhashem.usecase.mapper

import com.mohammadhashem.usecase.model.remote.response.CryptoResponse
import com.mohammadhashem.usecase.model.CryptoModel

fun CryptoResponse.toCryptos(): List<CryptoModel> {
    return this.data.map {
        CryptoModel(
            it.id.toString(),
            it.name,
            it.symbol,
            it.total_supply.toString(),
            it.self_reported_market_cap.toString(),
            "URL",
            ""
        )
    }
}
