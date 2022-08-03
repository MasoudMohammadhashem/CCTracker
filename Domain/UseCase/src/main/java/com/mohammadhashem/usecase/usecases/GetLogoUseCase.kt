package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.network.repository.logourl.RepositoryLogo
import com.mohammadhashem.network.repository.logourl.source.DataSourceRemoteLogo

class GetLogoUseCase(private val repositoryLogo: RepositoryLogo) {
    suspend operator fun invoke(id:String) = repositoryLogo.getLogo(id)
}