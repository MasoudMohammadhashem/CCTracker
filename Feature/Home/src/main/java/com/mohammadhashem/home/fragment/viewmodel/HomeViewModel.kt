package com.mohammadhashem.home.fragment.viewmodel

import androidx.lifecycle.viewModelScope
import com.mohammadhashem.baseui.BaseViewModel
import com.mohammadhashem.usecase.model.CryptoModel
import com.mohammadhashem.usecase.usecases.AllUseCases
import com.mohammadhashem.usecase.usecases.GetRemoteFullDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(allUseCase: AllUseCases) :BaseViewModel() {

    private val getRemote = GetRemoteFullDataUseCase(Dispatchers.Default,allUseCase.getRemoteUseCase,allUseCase.getLogoUseCase)
    private var _state = MutableStateFlow<List<CryptoModel>>(emptyList())
    var remoteStateFlow = _state.asStateFlow()
    init {
        viewModelScope.launch() {
            try {
                loading.emit(true)
                val result =  getRemote.invoke(10,"volume_24h", "asc", 10000.0,
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