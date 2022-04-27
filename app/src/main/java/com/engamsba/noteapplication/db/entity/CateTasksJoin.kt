package com.engamsba.noteapplication.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "user_repo_join",
    primaryKeys = ["userId", "repoId"],
    foreignKeys = [ForeignKey(
        entity = Tasks::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_categories")
    ), ForeignKey(entity = Categories::class, parentColumns = arrayOf("id"), childColumns = arrayOf("id_categories"))]
)
class CateTasksJoin(val userId: Int, val repoId: Int)