package com.engamsba.noteapplication.di

import android.content.Context
import androidx.room.Room
import com.engamsba.noteapplication.db.CacheDatabase
import com.engamsba.noteapplication.db.dao.CategoriesDao
import com.engamsba.noteapplication.db.dao.TaskDao
import com.engamsba.noteapplication.db.dao.TimerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    @Provides
    @Singleton
    internal fun provideDB(context: Context): CacheDatabase{
        return Room.databaseBuilder(context, CacheDatabase::class.java, "note_task.db")
            .build()
    }

    @Provides
    fun provideCategoriesDao(database: CacheDatabase): CategoriesDao = database.categoriesDao()

    @Provides
    fun provideTaskDao(database: CacheDatabase): TaskDao = database.taskDao()

    @Provides
    fun provideTimerDao(database: CacheDatabase): TimerDao = database.timerDao()


}