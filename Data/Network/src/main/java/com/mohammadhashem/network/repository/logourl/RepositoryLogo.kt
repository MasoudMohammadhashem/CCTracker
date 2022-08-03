package com.mohammadhashem.network.repository.logourl

import com.mohammadhashem.network.response.info.Info


interface RepositoryLogo {
    suspend fun getLogo(id:String): Info
}