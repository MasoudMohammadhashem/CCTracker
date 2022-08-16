package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.repository.RepositoryLogo

class GetLogoUseCase (private val repositoryLogo: RepositoryLogo) {
    suspend operator fun invoke(id:String) = repositoryLogo.getLogo(id)
}