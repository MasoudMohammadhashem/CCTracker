package com.mohammadhashem.repository.crypto

import com.mohammadhashem.network.sources.logo.DataSourceRemoteLogo
import com.mohammadhashem.usecase.model.remote.response.info.Info
import com.mohammadhashem.usecase.repository.RepositoryLogo
import javax.inject.Inject

class RepositoryLogoImpl (private val remote: DataSourceRemoteLogo):
    RepositoryLogo {
    override suspend fun getLogo(id: String): Info = remote.getCryptoCurrencies(id)

}