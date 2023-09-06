package com.mohammadhashem.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohammadhashem.domain.repository.dao.CryptoDao
import com.mohammadhashem.domain.model.CryptoModel


@Database(entities = [CryptoModel::class], version = 1)
abstract class CryptoDataBase : RoomDatabase() {
    abstract fun cryptoCurrenciesDao(): CryptoDao


//    companion object {
//        val DB_NAME = "TempBasketDb"
//
//        private var tempBasketDB: TempBasketDB? = null
//
//        fun getInstance(context: Context): TempBasketDB {
//            if (tempBasketDB == null) {
//                tempBasketDB = Room.databaseBuilder(context, TempBasketDB::class.java, DB_NAME)
//                    .allowMainThreadQueries().build()
//            }
//            return tempBasketDB!!
//        }
//    }
//
//    abstract fun tempBasketDao(): TempBasketDao

}