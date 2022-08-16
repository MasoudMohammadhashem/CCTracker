package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.mapper.toCryptos
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.repository.RepositoryCC
import com.mohammadhashem.usecase.repository.RepositoryLogo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Singleton
import kotlin.Exception

@Singleton
class GetRemoteFullDataUseCase (
    private val repoCC: RepositoryCC, private val repoLogo:RepositoryLogo,
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

    ): List<CryptoModel> =
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
                repoCC.deleteAll()
                buildList {
                        val myList = result.toCryptos()
                    myList.forEachIndexed { index, cryptoModel ->
//                        val logo = async { getLogo(cryptoModel) }
                        val logo = getLogo(cryptoModel)
//                        myList[index].imageUrl = logo.await()                        val logo = async { getLogo(cryptoModel) }
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