package com.example.newsapp.local.database

import androidx.lifecycle.LiveData
import com.example.newsapp.model.favorite.Favorite
import com.example.newsapp.model.news.Article
import javax.inject.Inject

class RepositoryDatabase @Inject constructor(private val newsDao: NewsDao){
    fun  getAllNews(): LiveData<List<Favorite>>
    {
        return newsDao.getallNews()
    }
    fun  inserNews(favorite: Favorite)=newsDao.insertNews (favorite)
    fun updateNews(favorite: Favorite)=newsDao.updatetNews(favorite)
    fun deleteNews(favorite: Favorite)=newsDao.deletetNews(favorite)
    fun deleteAllNews()=newsDao.deleteAllNews()
}