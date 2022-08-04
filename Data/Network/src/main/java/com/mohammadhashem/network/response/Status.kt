package com.mohammadhashem.network.response

data class Status(
    val credit_count: Long,
    val elapsed: Long,
    val error_code: Long,
    val error_message: String,
    val notice: String,
    val timestamp: String,
    val total_count: Long
)