package com.tochukwu.deliveryrooopractice.domain

import com.tochukwu.deliveryrooopractice.Core.Resource
import com.tochukwu.deliveryrooopractice.data.model.Applicable

import com.tochukwu.deliveryrooopractice.data.model.Payment
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getPayments(): Payment

}
