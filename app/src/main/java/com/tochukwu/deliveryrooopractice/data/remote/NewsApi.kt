package com.tochukwu.deliveryrooopractice.data.remote

import com.tochukwu.deliveryrooopractice.Core.Constants.Companion.API_KEY
import com.tochukwu.deliveryrooopractice.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {


    companion object {
       // const val BASE_URL = "https://newsapi.org/v2/"
        //const val API_KEY = BuildConfig.NEWS_API_ACCESS_KEY
    }

    @Headers("X-Api-Key: $API_KEY")
    @GET("top-headlines?country=us&pageSize=100")
    suspend fun getBreakingNews(): NewsResponse



}



