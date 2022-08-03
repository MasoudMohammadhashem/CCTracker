package com.mohammadhashem.cache.dao

import androidx.room.*
import com.mohammadhashem.cache.model.CryptoModel
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(billsModel: CryptoModel):Long

    @Update
    abstract fun update(billsModel: CryptoModel)

    @Delete
    abstract fun delete(billsModel: CryptoModel)

    @Query("SELECT * FROM CryptoModel")
    abstract fun getAll(): List<CryptoModel>


}