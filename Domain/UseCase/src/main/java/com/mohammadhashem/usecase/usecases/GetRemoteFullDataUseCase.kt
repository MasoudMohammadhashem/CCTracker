package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.di.DefaultDispatcher
import com.mohammadhashem.usecase.di.IoDispatcher
import com.mohammadhashem.usecase.mapper.toCryptos
import com.mohammadhashem.usecase.model.CryptoModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.lang.Exception
import javax.inject.Singleton

@Singleton
class GetRemoteFullDataUseCase @Inject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    private val allUseCases: AllUseCases
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
            val result = allUseCases.getRemoteUseCase.invoke(
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
                        add(index,myList[index])
                    }
                }
            } else {
                return@withContext buildList {
                    emptyList<CryptoModel>()
                }
            }
        }

    private suspend fun getLogo(cryptoModel: CryptoModel): String {
        try {
            val body = allUseCases.getLogoUseCase.invoke(cryptoModel.id).toString()
            var logo = body.split("logo=")
            logo = logo[1].split(", subreddit=")
            return logo[0].trim()
        }catch (e:Exception){
            e.message
        }
        return "https://media4.s-nbcnews.com/j/newscms/2019_01/2705191/nbc-social-default_b6fa4fef0d31ca7e8bc7ff6d117ca9f4.nbcnews-fp-1024-512.png"
    }

}