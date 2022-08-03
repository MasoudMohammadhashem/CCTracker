package com.mohammadhashem.network.repository.logourl

import com.mohammadhashem.network.repository.logourl.source.DataSourceRemoteLogo
import com.mohammadhashem.network.response.info.Info
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject

class RepositoryLogoImpl @Inject constructor (private val remote: DataSourceRemoteLogo):
    RepositoryLogo {
    override suspend fun getLogo(id: String): Info = remote.getCryptoCurrencies(id)

}