package com.example.newsapp.model.favorite

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable


@Entity(tableName ="news_tbl")
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    val id :Int=0,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)