package com.tochukwu.deliveryrooopractice.data.remote

import com.tochukwu.deliveryrooopractice.data.model.Payment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {


    companion object {
       // const val BASE_URL = "https://newsapi.org/v2/"
        //const val API_KEY = BuildConfig.NEWS_API_ACCESS_KEY
    }

    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    suspend fun getPayment(): Payment



}
