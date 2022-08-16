package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.repository.RepositoryCC

class DeleteDataBaseUseCase (private val repositoryCC: RepositoryCC) {
    suspend operator fun invoke() = repositoryCC.deleteAll()
}