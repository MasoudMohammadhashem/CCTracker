package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.cache.repository.RepositoryDataBase
import javax.inject.Inject

class CacheUseCase (private val repositoryDataBase: RepositoryDataBase) {
    suspend operator fun invoke() = repositoryDataBase.getAllCache()
}
