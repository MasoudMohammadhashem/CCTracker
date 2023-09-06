package com.mohammadhashem.domain.repository

import com.mohammadhashem.domain.model.remote.response.info.Info


interface RepositoryLogo {
    suspend fun getLogo(id:String): Info
}