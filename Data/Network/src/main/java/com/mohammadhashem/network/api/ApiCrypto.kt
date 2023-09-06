package com.mohammadhashem.network.api

import com.mohammadhashem.domain.model.remote.response.CryptoResponse
import com.mohammadhashem.domain.model.remote.response.info.Info
import com.mohammadhashem.utils.constval.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiCrypto {
    @GET("v1/cryptocurrency/listings/latest")
    @Headers(
        "X-CMC_PRO_API_KEY:$API_KEY",
        "Accept: application/json"
    )
    suspend fun getAllCurrencies(
        @Query("start")start:Int,
        @Query("limit")limit:Int,
        @Query("sort")sort:String,
        @Query("sort_dir")sort_type:String,
        @Query("volume_24h_min")volume24_min: Double,
        @Query("volume_24h_max")volume24_max: Double,
        @Query("percent_change_24h_min")percent_change24_min:Double,
        @Query("percent_change_24h_max")percent_change24_max:Double
    ): com.mohammadhashem.domain.model.remote.response.CryptoResponse

    @GET("v1/cryptocurrency/info")
    @Headers(
        "X-CMC_PRO_API_KEY:$API_KEY",
        "Accept: application/json"
    )
    suspend fun getLogoUrl(
        @Query("id")id:String,
    ): com.mohammadhashem.domain.model.remote.response.info.Info
}