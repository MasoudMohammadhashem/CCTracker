package com.mohammadhashem.usecase.di.all_usecase

import com.mohammadhashem.usecase.di.dispatchers.DefaultDispatcher
import com.mohammadhashem.usecase.di.dispatchers.IoDispatcher
import com.mohammadhashem.usecase.repository.RepositoryCC
import com.mohammadhashem.usecase.repository.RepositoryLogo
import com.mohammadhashem.usecase.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AllUseCaseCCModule {

    @Singleton
    @Provides
    fun provideUseCases(repositoryCC: RepositoryCC,
                        repositoryLogo: RepositoryLogo,
                        @DefaultDispatcher defaultDispatcher : CoroutineDispatcher,
                        @IoDispatcher ioDispatcher : CoroutineDispatcher,
    ): AllUseCases =
        AllUseCases(cacheUseCase = CacheUseCase(repositoryCC),
            deleteDataBaseUseCase = DeleteDataBaseUseCase(repositoryCC),
            getCacheUseCase = GetCacheUseCase(repositoryCC,ioDispatcher),
            getLogoUseCase = GetLogoUseCase(repositoryLogo),
            getRemoteFullDataUseCase = GetRemoteFullDataUseCase(repositoryCC,repositoryLogo,defaultDispatcher),
            insetCacheUseCase = InsertCacheUseCase(repositoryCC),
            remoteUseCase = RemoteUseCase(repositoryCC)
        )
}