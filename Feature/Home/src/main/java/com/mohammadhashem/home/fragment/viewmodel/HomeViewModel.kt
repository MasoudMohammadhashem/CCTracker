package com.mohammadhashem.home.fragment.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.mohammadhashem.baseui.base.BaseViewModel
import com.mohammadhashem.home.adapter.pagination.ConfigPagination
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.model.InputData
import com.mohammadhashem.usecase.usecases.AllUseCases
import com.mohammadhashem.usecase.usecases.GetCacheUseCase
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchData:GetRemoteFullDataUseCase,
                                        private val configPagination: ConfigPagination,
                                        private val getCacheUseCase: GetCacheUseCase) : BaseViewModel() {

    fun fetchData(inputData: InputData):Flow<PagingData<CryptoModel>> = configPagination.getTransactions(fetchData, inputData)
    fun fetchData():Flow<PagingData<CryptoModel>> {
        val result = configPagination.getTransactions(getCacheUseCase)
        loading.value = false
        return result
    }

}