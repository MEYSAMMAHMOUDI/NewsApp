package com.example.newsapp.viewmodel.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.news.NewsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelNews @Inject constructor(private val repository: RepositoryNews) :ViewModel() {

    private val responseMutableLiveData = MutableLiveData<NewsModel>()
     var responseState :Boolean = false
    val responseLiveData : LiveData<NewsModel>
        get() = responseMutableLiveData

    init {
        getListImages()
    }
    private fun getListImages() = viewModelScope.launch(Dispatchers.IO) {

        repository.getNewsList().let {

                response ->
            if (response.isSuccessful){
                responseMutableLiveData.postValue(response.body())
                responseState=true
            }else{
                Log.i("Error Response", "getListImages: " + response.errorBody())
                responseState=false
            }

        }

    }
}