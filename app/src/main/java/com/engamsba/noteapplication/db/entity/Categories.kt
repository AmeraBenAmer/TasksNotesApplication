package com.engamsba.noteapplication.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "categories")
data class Categories(

    @PrimaryKey(autoGenerate = true) override val id: Int = 0,
    @ColumnInfo(name = "name_categories") val nameCategories : String? = null,
    @ColumnInfo(name = "icon_categories") val iconCategories : String? = null,
    @ColumnInfo(name = "type_categories") val typeCategories: String? = null,

): BaseEntity