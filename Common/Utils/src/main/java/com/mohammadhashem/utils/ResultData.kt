package com.mohammadhashem.utils

sealed class ResultData<T>(val data: T? = null, val message: String?= null) {

    class Success<T>(data:T?): ResultData<T>(data)
    class Error<T>(message: String,data: T?=null): ResultData<T>(data,message)
//    class Loading<T>(message: String, data: T?=null): Resource<T>(null,null)
}