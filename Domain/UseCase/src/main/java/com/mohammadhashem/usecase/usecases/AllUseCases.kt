package com.mohammadhashem.usecase.usecases


data class AllUseCases (
    val getRemoteUseCase: GetRemoteUseCase,
    val getCacheUseCase: GetCacheUseCase,
    val insertCacheUseCase: InsertCacheUseCase,
    val getLogoUseCase: GetLogoUseCase
)