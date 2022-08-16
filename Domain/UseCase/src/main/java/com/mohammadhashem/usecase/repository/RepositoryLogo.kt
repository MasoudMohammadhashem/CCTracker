package com.mohammadhashem.usecase.repository

import com.mohammadhashem.usecase.model.remote.response.info.Info


interface RepositoryLogo {
    suspend fun getLogo(id:String): Info
}