package com.engamsba.noteapplication.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "timer")
data class Timer(
    @PrimaryKey(autoGenerate = true) override val id : Int = 0,
    @ColumnInfo(name = "title_timer") val titleTimer : String? = null,
    @ColumnInfo(name = "duration_timer") val  durationTimer: String? = null,
    @ColumnInfo(name = "note_timer") val noteTimer: String? = null,
    @ColumnInfo(name = "date_time_timer") val dataTime: String? = null
        ):BaseEntity