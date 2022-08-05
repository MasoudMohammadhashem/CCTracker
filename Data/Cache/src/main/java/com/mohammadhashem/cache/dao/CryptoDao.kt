package com.mohammadhashem.cache.dao

import androidx.room.*
import com.mohammadhashem.cache.model.CryptoModel
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(billsModel: CryptoModel):Long

    @Update
    abstract suspend fun update(billsModel: CryptoModel)

    @Delete
    abstract suspend fun delete(billsModel: CryptoModel)

    @Query("SELECT * FROM CryptoModel")
    abstract suspend fun getAll(): List<CryptoModel>

    @Query("DELETE FROM CryptoModel")
    abstract suspend fun deleteAll()
}