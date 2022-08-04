package com.mohammadhashem.network.response

import com.mohammadhashem.network.model.response.Data

data class CryptoResponse(
    val `data`: List<Data>,
    val status: Status
)