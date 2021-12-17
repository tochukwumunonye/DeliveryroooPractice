package com.tochukwu.deliveryrooopractice.domain

import com.tochukwu.deliveryrooopractice.Core.Resource

import com.tochukwu.deliveryrooopractice.data.model.Payment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: Repository
){

    operator fun invoke(): Flow<Resource<Payment>> = flow{
        try{
            emit(Resource.Loading<Payment>())
            val response = repository.getPayments()
            emit(Resource.Success<Payment>(response))
        } catch(e: HttpException){
            emit(Resource.Error<Payment>(e.localizedMessage ?: "An unexpected error occured"))
        }catch(e: IOException){
            emit(Resource.Error<Payment>("Couldn't reach server. Check your internet connection."))
        }
    }
}
