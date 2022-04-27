package com.engamsba.noteapplication.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.engamsba.noteapplication.db.entity.Memorize
import kotlinx.coroutines.flow.Flow


@Dao
abstract class MemorizeDao : BaseDao<Memorize>{

    @Query("SELECT * FROM memorize")
    abstract fun getAllMemorize(): Flow<List<Memorize>>

    @Query("SELECT * FROM memorize WHERE id = :id")
    abstract fun getMemoDetails(id : Int): Flow<Memorize>

    @Query("DELETE FROM memorize WHERE id= :id")
    abstract fun delete(id: Int)
}