package com.example.newsapp.local.database

import androidx.lifecycle.LiveData
import com.example.newsapp.model.news.Article
import javax.inject.Inject

class RepositoryDatabase @Inject constructor(private val newsDao: NewsDao){
    fun  getAllNews(): LiveData<List<Article>>
    {
        return newsDao.getallNews()
    }
    fun  inserNews(article: Article)=newsDao.insertNews (article)
    fun updateNews(article: Article)=newsDao.updatetNews(article)
    fun deleteNews(article: Article)=newsDao.deletetNews(article)
    fun deleteAllNews()=newsDao.deleteAllNews()
}