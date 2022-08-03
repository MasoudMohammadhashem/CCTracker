package com.mohammadhashem.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.mohammadhashem.baseui.BaseViewModel
import com.mohammadhashem.network.api.ApiCrypto
import com.mohammadhashem.network.response.CryptoResponse
import com.mohammadhashem.usecase.mapper.toCryptos
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.usecases.AllUseCases
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase
import com.mohammadhashem.utils.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(allUseCase: AllUseCases) :BaseViewModel() {

    val getremote = GetRemoteFullDataUseCase(Dispatchers.Default,allUseCase.getRemoteUseCase,allUseCase.getLogoUseCase)
    private var _state = MutableStateFlow<List<CryptoModel>>(emptyList())
    var remoteStateFlow = _state.asStateFlow()
    init {
        viewModelScope.launch() {
            try {
                loading.emit(true)
                val result =  getremote.invoke(1,"volume_24h", "asc", 10000.0,
                    100000.0, -100.0, 1.0)
                loading.emit(false)
                result.let { _state.emit(it) }
            }catch (e:Exception){
                loading.emit(false)
                e.message
            }
        }
    }

}