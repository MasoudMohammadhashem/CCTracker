package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.cache.repository.RepositoryDataBase

class DeleteDataBaseUseCase(private val repositoryDataBase: RepositoryDataBase) {
    suspend operator fun invoke() = repositoryDataBase.deleteAll()
}