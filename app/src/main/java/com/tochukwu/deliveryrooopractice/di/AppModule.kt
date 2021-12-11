package com.tochukwu.deliveryrooopractice.di

import com.tochukwu.deliveryrooopractice.Core.Constants
import com.tochukwu.deliveryrooopractice.data.remote.NewsApi
import com.tochukwu.deliveryrooopractice.data.remote.RepositoryImpl
import com.tochukwu.deliveryrooopractice.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: NewsApi): Repository {
        return RepositoryImpl(api)
    }
}



