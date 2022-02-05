package com.example.newsapp.remote

import com.example.newsapp.model.news.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v2/everything?q=tesla&from=2022-01-05&sortBy=publishedAt&apiKey=c06101d021a64f8a806c900ed3c05aa0")
    suspend fun getNews(): Response<NewsModel>
    //@Query("apikey") apikey: String = API_KEY

}