package com.stroke.stroke_ch2_ps208.domain.enity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "listArticle")
@Parcelize
data class ListArticle(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name: String,
    val publish : String,
    val imageUrl: String,
    val publishDate: String = "",
    val description: String = "",
    var isFavorite: Boolean = false
): Parcelable
