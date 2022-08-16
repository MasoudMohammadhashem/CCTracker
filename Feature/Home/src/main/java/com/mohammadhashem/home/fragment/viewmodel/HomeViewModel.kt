package com.mohammadhashem.home.fragment.viewmodel

import androidx.paging.PagingData
import com.mohammadhashem.baseui.base.BaseViewModel
import com.mohammadhashem.home.adapter.pagination.ConfigPagination
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.InputData
import com.mohammadhashem.usecase.repository.RepositoryCC
import com.mohammadhashem.usecase.usecases.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchData: AllUseCases,
    private val configPagination: ConfigPagination
) : BaseViewModel() {
    fun fetchData(inputData: InputData): Flow<PagingData<CryptoModel>> =
        configPagination.getTransactions(fetchData.getRemoteFullDataUseCase, inputData)

    fun fetchData(): Flow<PagingData<CryptoModel>> {
        val result = configPagination.getTransactions(fetchData.getCacheUseCase)
        loading.value = false
        return result
    }
}