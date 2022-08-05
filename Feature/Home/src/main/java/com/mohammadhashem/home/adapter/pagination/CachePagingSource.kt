package com.mohammadhashem.home.adapter.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.InputData
import com.mohammadhashem.usecase.usecases.GetCacheUseCase
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase

class CachePagingSource(
    private val getCacheUseCase: GetCacheUseCase
) : PagingSource<Int, CryptoModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CryptoModel> {
        val page = params.key ?: 1

        val list:List<CryptoModel> = getCacheUseCase.invoke()
        return LoadResult.Page(
            data = list,
            prevKey = if (page == 1) null else page - 1,
            nextKey = null,page
        )
    }

    override fun getRefreshKey(state: PagingState<Int, CryptoModel>): Int? {
        return state.anchorPosition?.coerceAtLeast(1)   // 1 is the first page
    }

}