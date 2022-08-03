package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.cache.model.CryptoModel
import com.mohammadhashem.cache.repository.RepositoryDataBase
import javax.inject.Inject

    class InsertCacheUseCase (private val repositoryDataBase: RepositoryDataBase) {
        suspend operator fun invoke(cryptoModel: CryptoModel) = repositoryDataBase.insertCache(cryptoModel)
    }