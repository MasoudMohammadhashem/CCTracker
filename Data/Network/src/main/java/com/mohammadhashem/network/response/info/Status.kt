package com.mohammadhashem.network.response.info

data class Status(
    val credit_count: Int,
    val elapsed: Int,
    val error_code: Int,
    val error_message: String,
    val notice: String,
    val timestamp: String
)