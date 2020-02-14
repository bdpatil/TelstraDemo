package com.example.telstrademo.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Row(
    @PrimaryKey(autoGenerate = false)
    val id_: Int,
    val description: String,
    val title: String,
    val imageHref: String

)