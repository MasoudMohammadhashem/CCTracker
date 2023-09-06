package com.mohammadhashem.domain.mapper

import com.mohammadhashem.domain.model.remote.response.CryptoResponse
import com.mohammadhashem.domain.model.CryptoModel

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
