package com.tochukwu.deliveryrooopractice.data.remote

import com.tochukwu.deliveryrooopractice.Core.Resource
import com.tochukwu.deliveryrooopractice.data.model.Applicable
import com.tochukwu.deliveryrooopractice.data.model.Payment
import com.tochukwu.deliveryrooopractice.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api : NewsApi
) : Repository{



    override suspend fun getPayments(): Payment {
        return api.getPayment()
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