package com.mohammadhashem.repository.crypto

import com.mohammadhashem.network.sources.logo.DataSourceRemoteLogo
import com.mohammadhashem.domain.model.remote.response.info.Info
import com.mohammadhashem.domain.repository.RepositoryLogo
import javax.inject.Inject

class RepositoryLogoImpl (private val remote: DataSourceRemoteLogo):
    com.mohammadhashem.domain.repository.RepositoryLogo {
    override suspend fun getLogo(id: String): com.mohammadhashem.domain.model.remote.response.info.Info = remote.getCryptoCurrencies(id)

}