package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.repository.RepositoryCC

class CacheUseCase (private val repositoryCC: RepositoryCC) {
    suspend operator fun invoke() = repositoryCC.getAllCache()
}
