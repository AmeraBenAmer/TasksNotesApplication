package com.engamsba.noteapplication.db.dao

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.engamsba.noteapplication.db.entity.Categories
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
abstract class CategoriesDao : BaseDao<Categories>{

    @Query("SELECT * FROM  categories ORDER BY id DESC")
    abstract fun getAllCategories(): Flow<List<Categories>>

//    @get:Query("SELECT * FROM  categories ORDER BY id DESC")
//    abstract val allCategory :Flow<List<Categories>>

    @Query("DELETE FROM categories WHERE  id = :id")
    abstract fun delete(id : Int)
}