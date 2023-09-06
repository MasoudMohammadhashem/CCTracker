package com.mohammadhashem.network.sources.logo

import com.mohammadhashem.domain.model.remote.response.info.Info

interface DataSourceRemoteLogo {
    suspend fun getCryptoCurrencies(id:String): com.mohammadhashem.domain.model.remote.response.info.Info
}