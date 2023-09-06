package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.domain.repository.RepositoryLogo

class GetLogoUseCase (private val repositoryLogo: com.mohammadhashem.domain.repository.RepositoryLogo) {
    suspend operator fun invoke(id:String) = repositoryLogo.getLogo(id)
}