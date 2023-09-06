package com.mohammadhashem.domain.model.remote.response

import com.mohammadhashem.network.model.response.Data

data class CryptoResponse(
    val `data`: List<Data>,
    val status: Status
)