package com.tochukwu.deliveryrooopractice.data.remote

import com.tochukwu.deliveryrooopractice.data.model.Article
import com.tochukwu.deliveryrooopractice.data.model.NewsResponse
import com.tochukwu.deliveryrooopractice.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api : NewsApi
) : Repository{

    override suspend fun getNews(): List<Article> {
        return api.getBreakingNews().articles
    }

}


/**

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}
© 2021 GitHub, Inc.
Terms
Privacy
        **/