package com.engamsba.noteapplication.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.engamsba.noteapplication.db.entity.Timer
import kotlinx.coroutines.flow.Flow

@Dao
abstract class TimerDao : BaseDao<Timer>{

    @Query("SELECT * FROM timer")
    abstract fun getAllTimer(): Flow<List<Timer>>

    @Query("SELECT * FROM timer WHERE id = :id")
    abstract fun getTimerDetails(id : Int): Flow<Timer>

    @Query("DELETE FROM timer WHERE id= :id")
    abstract fun delete(id: Int)
}