package com.engamsba.noteapplication.repository

import com.engamsba.noteapplication.db.CacheDatabase
import com.engamsba.noteapplication.db.entity.Categories
import javax.inject.Inject



class MainRepository @Inject constructor(
    private val db: CacheDatabase
) {
    suspend fun insert(categories:Categories) = db.categoriesDao().insert(categories)

    suspend fun update(categories : Categories) = db.categoriesDao().update(categories)

    fun getAllCategories() = db.categoriesDao().getAllCategories()

    //val allCategories = db.categoriesDao().getAllCategories()

    fun deleteCategories(id: Int) =
        db.categoriesDao().delete(id)
}