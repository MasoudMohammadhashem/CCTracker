package com.mohammadhashem.network.repository.logourl.source

import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.network.response.info.Info
import com.mohammadhashem.utils.ResultData
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject

class DataSourceRemoteLogoImpl @Inject constructor(private val api: ApiCrypto): DataSourceRemoteLogo {
    override suspend fun getCryptoCurrencies(id: String): Info = api.getLogoUrl(id)
}