package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.repository.RepositoryCC
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GetCacheUseCase (

    private val repoCC: RepositoryCC,
    private val dispatcher : CoroutineDispatcher
){

    suspend operator fun invoke(): List<CryptoModel> =
        withContext(dispatcher) {
//            return@withContext repoCC.getAllCache()
            return@withContext buildList {
                repoCC.getAllCache()
            }
/*            val result = repoCC.getAllCache()
            buildList {
                var list:List<com.mohammadhashem.domain.model.CryptoModel> = ArrayList()

                list = result
                if (list.isNotEmpty()) {
                    return@withContext list
                } else {
                    throw Exception("DataBase is empty")
                }
            }*/
        }
}