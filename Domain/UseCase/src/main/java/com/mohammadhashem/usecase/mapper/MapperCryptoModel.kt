package com.mohammadhashem.usecase.mapper

import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.usecase.model.CryptoModel

fun CryptoResponse.toCryptos(): List<CryptoModel> {
    return this.data.map {
        CryptoModel(
            it.id.toString(),
            it.name,
            it.symbol,
            "NULL",
            it.self_reported_market_cap.toString(),
            "URL",
            "EXTRA_EMPTY"
        )
    }
}

fun List<com.mohammadhashem.cache.model.CryptoModel>.toCryptos(): List<CryptoModel> {
    return this.map {
        CryptoModel(
            it.id.toString(),
            it.name,
            it.symbol,
            it.percent_change24,
            it.market_cap.toString(),
            it.imageUrl,
            "EXTRA_EMPTY"
        )
    }
}

fun List<CryptoModel>.toCryptosDao(): List<com.mohammadhashem.cache.model.CryptoModel> {
    return this.map {
        com.mohammadhashem.cache.model.CryptoModel(
            it.id.toString(),
            it.name,
            it.symbol,
            it.percent_change24,
            it.market_cap.toString(),
            it.imageUrl,
            "EXTRA_EMPTY"
        )
    }
}

fun CryptoModel.toCryptosDao() = com.mohammadhashem.cache.model.CryptoModel(
    id = id.toString(),
    name = name,
    symbol = symbol,
    percent_change24 = percent_change24,
    market_cap = market_cap.toString(),
    imageUrl = imageUrl,
    "EXTRA_EMPTY"
)

