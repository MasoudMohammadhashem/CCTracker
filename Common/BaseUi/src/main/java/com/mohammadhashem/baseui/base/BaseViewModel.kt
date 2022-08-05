package com.mohammadhashem.baseui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow


abstract class BaseViewModel  : ViewModel() {
    val loading = MutableStateFlow<Boolean>(false)
    val error = MutableSharedFlow<String>()

    override fun onCleared() {
        super.onCleared()
    }

}