package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.mapper.toCryptos
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.repository.RepositoryCC
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetCacheUseCase (

    private val repoCC: RepositoryCC,
    private val dispatcher : CoroutineDispatcher
){

    suspend operator fun invoke(): List<CryptoModel> =
        withContext(dispatcher) {
            val result = repoCC.getAllCache()
            buildList {
                var list:List<CryptoModel> = ArrayList()

                list = result
                if (list.isNotEmpty()) {
                    return@withContext list
                } else {
                    throw Exception("DataBase is empty")
                }
            }


        }

}