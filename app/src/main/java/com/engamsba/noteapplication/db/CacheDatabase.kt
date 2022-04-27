package com.engamsba.noteapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.engamsba.noteapplication.db.dao.CategoriesDao
import com.engamsba.noteapplication.db.dao.MemorizeDao
import com.engamsba.noteapplication.db.dao.TaskDao
import com.engamsba.noteapplication.db.dao.TimerDao
import com.engamsba.noteapplication.db.entity.Categories
import com.engamsba.noteapplication.db.entity.Memorize
import com.engamsba.noteapplication.db.entity.Tasks
import com.engamsba.noteapplication.db.entity.Timer


@Database(
    entities = [
        Categories::class,
    Memorize::class,
    Tasks::class,
    Timer::class
    ],
    version = 7
    , exportSchema = false
)
abstract class CacheDatabase: RoomDatabase() {

    abstract fun memorizeDao(): MemorizeDao
    abstract fun categoriesDao(): CategoriesDao
    abstract fun taskDao(): TaskDao
    abstract fun timerDao(): TimerDao
}