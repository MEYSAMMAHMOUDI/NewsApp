package com.example.newsapp.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.model.news.Article

@Database(entities = [Article::class],version = 1,exportSchema = false)
abstract class DatabaseNews:RoomDatabase() {
    abstract  fun getNewsDao():NewsDao
}