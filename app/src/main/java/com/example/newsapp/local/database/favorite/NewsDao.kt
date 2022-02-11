package com.example.newsapp.local.database.favorite

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.model.news.Article

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_tbl")
    fun getallNews(): LiveData<List<Article>>

    @Insert()
    fun insertNews(article: Article)

    @Delete
    fun deletetNews(article: Article)

    @Update
    fun updatetNews(article: Article)

    @Query("DELETE  FROM news_tbl")
    fun deleteAllNews()
}