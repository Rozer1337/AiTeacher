package com.example.aiteacher.database

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "books")
data class BookEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val grade : String,
    val name : String,
    val subject : String,
    val paragraphCount : Int,
    val chatCount : Int,
    val pageCount : Int
)