package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.di.IoDispatcher
import com.mohammadhashem.usecase.mapper.toCryptos
import com.mohammadhashem.usecase.mapper.toCryptosDao
import com.mohammadhashem.usecase.model.CryptoModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCacheUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val allUseCases: AllUseCases
){
    suspend operator fun invoke(): List<CryptoModel> =
        withContext(dispatcher) {
            val result = allUseCases.cacheUseCase.invoke()
            buildList {
                var list:List<CryptoModel> = ArrayList()

                list = result.toCryptos()
                if (list.isNotEmpty()) {
                    return@withContext list
                } else {
                    throw Exception("DataBase is empty")
                }
            }


        }

}