package com.mohammadhashem.usecase.usecases

data class AllUseCases(
    val cacheUseCase: CacheUseCase,
    val deleteDataBaseUseCase: DeleteDataBaseUseCase,
    val getCacheUseCase: GetCacheUseCase,
    val getLogoUseCase: GetLogoUseCase,
    val getRemoteFullDataUseCase: GetRemoteFullDataUseCase,
    val insetCacheUseCase: InsertCacheUseCase,
    val remoteUseCase: RemoteUseCase
)
