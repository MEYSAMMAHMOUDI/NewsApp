package com.example.newsapp.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.model.favorite.Favorite
import com.example.newsapp.model.news.Article

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_tbl")
    fun getallNews(): LiveData<List<Favorite>>

    @Insert()
    fun insertNews(favorite: Favorite)

    @Delete
    fun deletetNews(favorite: Favorite)

    @Update
    fun updatetNews(favorite: Favorite)

    @Query("DELETE  FROM news_tbl")
    fun deleteAllNews()
}