package com.example.newsapp.model.news

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName ="news_tbl")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id :Int=0,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
):Parcelable