package com.tochukwu.deliveryrooopractice.domain

import com.tochukwu.deliveryrooopractice.Core.Resource
import com.tochukwu.deliveryrooopractice.data.model.Article
import com.tochukwu.deliveryrooopractice.data.model.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: Repository
){
    operator fun invoke() : Flow<Resource<out List<Any>>> = flow{
        try{
            emit(Resource.Loading<List<Article>>())
            val response = repository.getNews()

            emit(Resource.Success<List<Article>>(response))

        } catch(e: HttpException){
            emit(Resource.Error<List<NewsResponse>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException){
            emit(Resource.Error<List<NewsResponse>>("Couldn't reach server. Check your internet connection."))
        }
    }
}



