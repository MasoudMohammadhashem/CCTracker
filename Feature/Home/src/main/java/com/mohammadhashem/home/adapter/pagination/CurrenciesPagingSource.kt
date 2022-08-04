package com.mohammadhashem.home.adapter.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.InputData
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase


class CurrenciesPagingSource (private val getRemoteFullDataUseCase: GetRemoteFullDataUseCase,private val inputData: InputData) : PagingSource<Int, CryptoModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CryptoModel> {
        val page = params.key ?: 1


        return try {
            val list = getRemoteFullDataUseCase.invoke(inputData.start,inputData.limit,
                inputData.sort,inputData.sort_type,inputData.volume24_min,inputData.volume24_max,inputData.percent_change24_min,inputData.percent_change24_max)
            LoadResult.Page(
                data = list,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (list.isEmpty()) null else page + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CryptoModel>): Int? {
        return state.anchorPosition?.coerceAtLeast(1)   // 1 is the first page
    }

}