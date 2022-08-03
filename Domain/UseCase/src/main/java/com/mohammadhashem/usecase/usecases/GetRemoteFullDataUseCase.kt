package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.di.IoDispatcher
import com.mohammadhashem.usecase.mapper.toCryptos
import com.mohammadhashem.usecase.model.CryptoModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.lang.Exception

class GetRemoteFullDataUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val remoteUseCase: GetRemoteUseCase, private val getLogoUseCase: GetLogoUseCase
) {
    suspend operator fun invoke(
        limit: Int,
        sort: String,
        sort_type: String,
        percent_change24_min: Double,
        percent_change24_max: Double,
        volume24_min: Double,
        volume24_max: Double
    ): List<CryptoModel> =
        withContext(dispatcher) {
            val result = remoteUseCase.invoke(
                limit,
                sort,
                sort_type,
                percent_change24_min,
                percent_change24_max,
                volume24_min,
                volume24_max
            )
            if (result.status.error_code==0) {
                return@withContext buildList {
                    launch {
                        var myList = result.toCryptos()
                        myList?.forEachIndexed { index, cryptoModel ->
                            val logo = getLogo(cryptoModel)
                            myList[index].imageUrl = logo
                        }
                        return@launch
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
            val body = getLogoUseCase.invoke(cryptoModel.id)
            var mainJSONObj:JSONObject = JSONObject(body.data.toString())
// get category JSONObject from mainJSONObj
            var categoryJSONObj:JSONObject =mainJSONObj.getJSONObject(cryptoModel.id);

// get all keys from categoryJSONObj

            var iterator:Iterator<String>  = categoryJSONObj.keys();
            while (iterator.hasNext()) {
                val key:String  = iterator.next();
                println("OUR VALUE:$key    ${categoryJSONObj.optString(key)}")
            }






//            val data = JSONObject(body.data.toString()).getString(cryptoModel.id)
//            val ID = JSONObject(data.toString()).getString(cryptoModel.id)
//            return JSONObject(ID).getString("logo")
        }catch (e:Exception){
            e.message
        }
        return "https://media4.s-nbcnews.com/j/newscms/2019_01/2705191/nbc-social-default_b6fa4fef0d31ca7e8bc7ff6d117ca9f4.nbcnews-fp-1024-512.png"
    }

    fun test(){}


}