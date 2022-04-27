package com.engamsba.noteapplication.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.engamsba.noteapplication.db.entity.Tasks
import kotlinx.coroutines.flow.Flow


@Dao
abstract class TaskDao : BaseDao<Tasks>{

    @Query("SELECT * FROM tasks")
    abstract fun getAllTasks(): Flow<List<Tasks>>

    @Query("SELECT * FROM tasks WHERE id = :id")
    abstract fun getTasksDetails(id : Int): Flow<Tasks>

    @Query("DELETE FROM tasks WHERE id= :id")
    abstract fun delete(id: Int)
}