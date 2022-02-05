package com.example.newsapp.viewmodel.news

import com.example.newsapp.remote.ApiService
import javax.inject.Inject

class RepositoryNews @Inject constructor(private val apiService: ApiService){
    suspend fun getNewsList() = apiService.getNews()
}