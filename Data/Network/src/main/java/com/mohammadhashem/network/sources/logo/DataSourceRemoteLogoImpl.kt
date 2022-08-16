package com.mohammadhashem.network.sources.logo

import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.usecase.model.remote.response.info.Info

class DataSourceRemoteLogoImpl (private val api: ApiCrypto):
    DataSourceRemoteLogo {
    override suspend fun getCryptoCurrencies(id: String): Info = api.getLogoUrl(id)
}