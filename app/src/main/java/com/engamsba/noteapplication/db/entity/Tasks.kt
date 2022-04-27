package com.engamsba.noteapplication.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "tasks")
data class Tasks(
    @PrimaryKey(autoGenerate = true) override val id :Int = 0,
    @ColumnInfo(name = "title_task") val titleTask: String? = null,
    @ColumnInfo(name = "description_task") val descriptionTask: String? = null,
    @ColumnInfo(name = "reminder_time") val reminderTime : String? = null,
    @ColumnInfo(name = "data_time_task") val dateTimeTask : String? = null,
    @ColumnInfo(name = "day_task") val dayOfTask : String? = null,
): BaseEntity