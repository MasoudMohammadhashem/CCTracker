package com.mohammadhashem.network.repository.logourl.source

import com.mohammadhashem.network.response.info.Info
import com.mohammadhashem.utils.ResultData
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

interface DataSourceRemoteLogo {
    suspend fun getCryptoCurrencies(id:String): Info
}