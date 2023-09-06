package com.mohammadhashem.home.adapter.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.model.InputData
import com.mohammadhashem.usecase.usecases.GetCacheUseCase
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase
import com.mohammadhashem.usecase.usecases.InsertCacheUseCase
import com.mohammadhashem.utils.constval.PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConfigPagination @Inject constructor() {

    fun getTransactions(getRemoteData: GetRemoteFullDataUseCase,insertCacheUseCase: InsertCacheUseCase, inputData: com.mohammadhashem.domain.model.InputData): Flow<PagingData<com.mohammadhashem.domain.model.CryptoModel>> {

        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { RemotePagingSource(getRemoteData,insertCacheUseCase,inputData) }
        ).flow
    }
    fun getTransactions(getCacheUseCase: GetCacheUseCase): Flow<PagingData<com.mohammadhashem.domain.model.CryptoModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CachePagingSource(getCacheUseCase) }
        ).flow
    }
}