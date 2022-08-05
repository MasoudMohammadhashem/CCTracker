package com.mohammadhashem.usecase.usecases


data class AllUseCases (
    val remoteUseCase: RemoteUseCase,
    val cacheUseCase: CacheUseCase,
    val insertCacheUseCase: InsertCacheUseCase,
    val getLogoUseCase: GetLogoUseCase,
    val deleteDataBaseUseCase: DeleteDataBaseUseCase
)