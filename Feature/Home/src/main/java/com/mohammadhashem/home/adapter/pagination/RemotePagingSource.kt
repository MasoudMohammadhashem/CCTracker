package com.mohammadhashem.home.adapter.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mohammadhashem.domain.model.CryptoModel
import com.mohammadhashem.domain.model.InputData
import com.mohammadhashem.usecase.usecases.GetCacheUseCase
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase
import com.mohammadhashem.usecase.usecases.InsertCacheUseCase


class RemotePagingSource(
    private val getRemoteFullDataUseCase: GetRemoteFullDataUseCase,
    private val insertDataUseCase: InsertCacheUseCase,
    private val inputData: com.mohammadhashem.domain.model.InputData
) : PagingSource<Int, com.mohammadhashem.domain.model.CryptoModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.mohammadhashem.domain.model.CryptoModel> {

            val page = params.key ?: 1
            val list = getRemoteFullDataUseCase.invoke(
                inputData.start,
                inputData.limit,
                inputData.sort,
                inputData.sort_type,
                inputData.volume24_min,
                inputData.volume24_max,
                inputData.percent_change24_min,
                inputData.percent_change24_max
            )

        return  LoadResult.Page(
                data = list,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (list.isEmpty()) null else page + 1
            )


    }

    override fun getRefreshKey(state: PagingState<Int, com.mohammadhashem.domain.model.CryptoModel>): Int? {
        return state.anchorPosition?.coerceAtLeast(1)   // 1 is the first page
    }

}
