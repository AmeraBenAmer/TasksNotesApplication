package com.engamsba.noteapplication.db

import com.engamsba.noteapplication.db.entity.Categories
import com.engamsba.noteapplication.db.entity.Memorize
import com.engamsba.noteapplication.db.entity.Tasks
import com.engamsba.noteapplication.db.entity.Timer
import kotlinx.coroutines.flow.Flow

interface NoteDatabase {

    fun getAllMemorize(): Flow<Memorize>
    fun getAllTasks(): Flow<Tasks>
    fun getAllTimer(): Flow<Timer>
    fun getAllCategories(): Flow<Categories>
    suspend fun insertMemorize(data : Memorize)
    suspend fun insertTask(data : Tasks)
    suspend fun insertTimer(data : Timer)
    suspend fun insertCategorize(data : Categories)
}
