package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.domain.repository.RepositoryCC

class CacheUseCase (private val repositoryCC: com.mohammadhashem.domain.repository.RepositoryCC) {
    suspend operator fun invoke() = repositoryCC.getAllCache()
}
