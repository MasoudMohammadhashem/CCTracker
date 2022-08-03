package com.mohammadhashem.usecase.model

data class CryptoModel(
    val id: String,
    val name: String,
    val symbol: String,
    val percent_change24: String,
    val market_cap: String,
    var imageUrl: String,
    val s: String
)
