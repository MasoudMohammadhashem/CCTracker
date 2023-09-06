package com.mohammadhashem.domain.repository.dao

import androidx.room.*
import com.mohammadhashem.domain.model.CryptoModel
import kotlinx.coroutines.flow.Flow
@Dao
abstract class CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(cryptoModel: CryptoModel):Long

    @Update
    abstract suspend fun update(cryptoModel: CryptoModel)

    @Delete
    abstract suspend fun delete(cryptoModel: CryptoModel)

    @Query("SELECT * FROM CryptoModel")
    abstract fun getAll(): Flow<List<CryptoModel>>

    @Query("DELETE FROM CryptoModel")
    abstract suspend fun deleteAll()
}