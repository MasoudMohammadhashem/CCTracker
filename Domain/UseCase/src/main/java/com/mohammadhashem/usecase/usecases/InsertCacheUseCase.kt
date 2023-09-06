package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.repository.RepositoryCC

class InsertCacheUseCase(private val repositoryCC: RepositoryCC) {
    suspend operator fun invoke(cryptoModel: CryptoModel) = repositoryCC.insertCache(cryptoModel)
}