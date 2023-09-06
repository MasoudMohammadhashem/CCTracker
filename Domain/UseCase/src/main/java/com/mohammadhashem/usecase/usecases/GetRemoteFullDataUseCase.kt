package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.domain.mapper.toCryptos
import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.repository.RepositoryCC
import com.mohammadhashem.domain.repository.RepositoryLogo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Singleton
import kotlin.Exception

@Singleton
class GetRemoteFullDataUseCase (
    private val repoCC: com.mohammadhashem.domain.repository.RepositoryCC, private val repoLogo: com.mohammadhashem.domain.repository.RepositoryLogo,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(
        start:Int,
        limit: Int,
        sort: String,
        sort_type: String,
        volume24_min: Double,
        volume24_max: Double,
        percent_change24_min: Double,
        percent_change24_max: Double,

    ): List<com.mohammadhashem.domain.model.CryptoModel> =
        withContext(dispatcher) {
            val result = repoCC.getAllCryptoCurrencies(
                start,
                limit,
                sort,
                sort_type,
                volume24_min,
                volume24_max,
                percent_change24_min,
                percent_change24_max,

            )
            if (result.status.error_code==0L) {
                buildList {
                        val myList = result.toCryptos()
                    myList.forEachIndexed { index, cryptoModel ->
                        val logo = getLogo(cryptoModel)
                        myList[index].imageUrl = logo
                        repoCC.insertCache(myList[index])
                        add(index,myList[index])
                    }
                }
            } else {
                throw  Exception(result.status.error_message)
            }
        }

    private suspend fun getLogo(cryptoModel: CryptoModel): String {
        return try {
            val body = repoLogo.getLogo(cryptoModel.id).toString()
            var logo = body.split("logo=")
            logo = logo[1].split(", subreddit=")
            logo[0].trim()
        }catch (e:Exception){
            "https://toppng.com//public/uploads/preview/bitcoin-11530977752iex2eerfgp.png"
        }
    }

}