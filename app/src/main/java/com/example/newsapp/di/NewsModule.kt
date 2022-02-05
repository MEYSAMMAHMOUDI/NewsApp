package com.example.newsapp.di

import com.example.newsapp.BuildConfig
import com.example.newsapp.remote.ApiService
import com.example.newsapp.utils.Unit.Companion.BASE_URL
import com.example.newsapp.viewmodel.news.RepositoryNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NewsModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        api: ApiService
    ) = RepositoryNews(api)

    @Singleton
    @Provides
    fun providesNewsApi(): ApiService {


        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClient.addInterceptor(interceptor)
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(ApiService::class.java)
    }
}
