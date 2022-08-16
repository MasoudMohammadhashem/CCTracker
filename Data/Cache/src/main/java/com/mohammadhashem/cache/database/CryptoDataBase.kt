package com.mohammadhashem.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohammadhashem.cache.dao.CryptoDao
import com.mohammadhashem.usecase.model.CryptoModel


@Database(entities = [CryptoModel::class], version = 1)
abstract class CryptoDataBase : RoomDatabase() {
    abstract fun cryptoCurrenciesDao(): CryptoDao
}