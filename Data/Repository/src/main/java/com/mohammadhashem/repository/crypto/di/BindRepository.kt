//package com.mohammadhashem.repository.crypto.di
//
//import com.mohammadhashem.repository.crypto.RepositoryCCImpl
//import com.mohammadhashem.repository.crypto.RepositoryLogoImpl
//import com.mohammadhashem.usecase.repository.RepositoryCC
//import com.mohammadhashem.usecase.repository.RepositoryLogo
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class BindRepository {
//    //It Needs @Inject Annotation
//    @Singleton
//    @Binds
//    abstract fun bindRepositoryNetwork(dataSourceRemote: RepositoryCCImpl): RepositoryCC
//
//    @Singleton
//    @Binds
//    abstract fun bindRepositoryNetworkLogo(dataSourceRemote: RepositoryLogoImpl): RepositoryLogo
//}