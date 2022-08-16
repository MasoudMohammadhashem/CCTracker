package com.mohammadhashem.usecase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class CryptoModel(
    @PrimaryKey
    val id: String,
    val name: String,
    val symbol: String,
    val percent_change24: String,
    val market_cap: String,
    var imageUrl: String,
    val s: String
)
