package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.repository.RepositoryCC

class InsertCacheUseCase(private val repositoryCC: RepositoryCC) {
    suspend operator fun invoke(cryptoModel: CryptoModel) = repositoryCC.insertCache(cryptoModel)
}