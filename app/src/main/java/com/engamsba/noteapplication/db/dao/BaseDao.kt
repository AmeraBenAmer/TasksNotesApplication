package com.engamsba.noteapplication.db.dao

import androidx.room.*
import com.engamsba.noteapplication.db.entity.BaseEntity
import com.engamsba.noteapplication.db.entity.Categories
import kotlinx.coroutines.flow.StateFlow

interface BaseDao<T : BaseEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: List<T>)

    @Update
    suspend fun update(t: T)

    @Delete
    suspend fun delete(t: T)


}