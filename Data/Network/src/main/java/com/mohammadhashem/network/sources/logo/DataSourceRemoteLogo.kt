package com.mohammadhashem.network.sources.logo

import com.mohammadhashem.usecase.model.remote.response.info.Info

interface DataSourceRemoteLogo {
    suspend fun getCryptoCurrencies(id:String): Info
}