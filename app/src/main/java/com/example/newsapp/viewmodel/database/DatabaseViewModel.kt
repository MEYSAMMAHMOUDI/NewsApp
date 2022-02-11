package com.example.newsapp.viewmodel.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.news.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DatabaseViewModel @Inject constructor(val databaseRepository: RepositoryDatabase) : ViewModel() {
    val NewsData: MutableLiveData<List<Article>> = MutableLiveData()


    fun getAllNote(): LiveData<List<Article>> {
        return databaseRepository.getAllNews()
    }

    fun insertNews(favoriteEntity: Article) =
        viewModelScope.launch(Dispatchers.IO) { databaseRepository.inserNews(favoriteEntity) }

    fun updateNews(favoriteEntity: Article) =
        viewModelScope.launch(Dispatchers.IO) { databaseRepository.updateNews(favoriteEntity) }

    fun deleteNews(favoriteEntity: Article) =
        viewModelScope.launch(Dispatchers.IO) { databaseRepository.deleteNews(favoriteEntity) }
    fun deleteAllNews()=
        viewModelScope.launch(Dispatchers.IO) {databaseRepository.deleteAllNews()  }
}