package com.example.newsapp.viewmodel.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.local.database.RepositoryDatabase
import com.example.newsapp.model.favorite.Favorite
import com.example.newsapp.model.news.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DatabaseViewModel @Inject constructor(val databaseRepository: RepositoryDatabase) : ViewModel() {
    val NewsData: MutableLiveData<List<Favorite>> = MutableLiveData()


    fun getAllNote(): LiveData<List<Favorite>> {
        return databaseRepository.getAllNews()
    }

    fun insertNews(favoriteEntity: Favorite) =
        viewModelScope.launch(Dispatchers.IO) { databaseRepository.inserNews(favoriteEntity) }

    fun updateNews(favoriteEntity: Favorite) =
        viewModelScope.launch(Dispatchers.IO) { databaseRepository.updateNews(favoriteEntity) }

    fun deleteNews(favoriteEntity: Favorite) =
        viewModelScope.launch(Dispatchers.IO) { databaseRepository.deleteNews(favoriteEntity) }
    fun deleteAllNews()=
        viewModelScope.launch(Dispatchers.IO) {databaseRepository.deleteAllNews()  }
}