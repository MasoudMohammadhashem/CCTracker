package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.domain.repository.RepositoryCC

class DeleteDataBaseUseCase (private val repositoryCC: RepositoryCC) {
    suspend operator fun invoke() = repositoryCC.deleteAll()
}