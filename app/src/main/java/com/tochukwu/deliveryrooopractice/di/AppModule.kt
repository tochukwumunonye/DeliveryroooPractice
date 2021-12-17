package com.tochukwu.deliveryrooopractice.di

import com.tochukwu.deliveryrooopractice.Core.Constants
import com.tochukwu.deliveryrooopractice.data.remote.NewsApi
import com.tochukwu.deliveryrooopractice.data.remote.RepositoryImpl
import com.tochukwu.deliveryrooopractice.domain.Repository
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


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient{
       val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .readTimeout(30,  TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }



    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): NewsApi {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: NewsApi): Repository {
        return RepositoryImpl(api)
    }
}



