package com.mohammadhashem.home.adapter.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.InputData
import com.mohammadhashem.usecase.usecases.GetCacheUseCase
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase
import com.mohammadhashem.utils.constval.PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConfigPagination @Inject constructor() {

    fun getTransactions(getRemoteData: GetRemoteFullDataUseCase, inputData: InputData): Flow<PagingData<CryptoModel>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { RemotePagingSource(getRemoteData,inputData) }
        ).flow
    }
    fun getTransactions(getCacheUseCase: GetCacheUseCase): Flow<PagingData<CryptoModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CachePagingSource(getCacheUseCase) }
        ).flow
    }
}