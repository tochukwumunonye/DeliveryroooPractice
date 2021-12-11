package com.tochukwu.deliveryrooopractice.domain

import com.tochukwu.deliveryrooopractice.data.model.Article
import com.tochukwu.deliveryrooopractice.data.model.NewsResponse

interface Repository {

    suspend fun getNews(): List<Article>

}

/**
suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
    RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

suspend fun searchNews(searchQuery: String,pageNumber: Int) =
    RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto **/
