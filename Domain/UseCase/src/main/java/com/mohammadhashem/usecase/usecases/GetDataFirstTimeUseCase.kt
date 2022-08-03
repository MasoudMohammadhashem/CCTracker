package com.mohammadhashem.usecase.usecases

import com.mohammadhashem.usecase.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetDataFirstTimeUseCase @Inject constructor(
    @DefaultDispatcher dispatcher: CoroutineDispatcher,
    remoteUserCase: GetRemoteUseCase, cacheUserCase: GetCacheUseCase, insertCacheUseCase: InsertCacheUseCase) {


}