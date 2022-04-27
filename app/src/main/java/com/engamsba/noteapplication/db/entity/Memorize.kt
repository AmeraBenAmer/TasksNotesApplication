package com.engamsba.noteapplication.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "memorize"
)
data class Memorize(
    @PrimaryKey(autoGenerate = true) override val id: Int = 0,
    //@ColumnInfo(name = "image_list") val imageList : ArrayList<ImageMemorize> = arrayListOf(),
    @ColumnInfo(name = "title_memory") val titleMemorize: String? = null,
    @ColumnInfo(name = "description_memory") val descriptionMemorize: String? = null,
    @ColumnInfo(name = "location_memory") val locationMemorize : String? = null,
    @ColumnInfo(name = "id_categories") val idCategories : String? = null,

): BaseEntity