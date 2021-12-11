package com.tochukwu.deliveryrooopractice.Presentation

import androidx.lifecycle.ViewModel
import com.tochukwu.deliveryrooopractice.Core.Resource
import com.tochukwu.deliveryrooopractice.data.model.Article
import com.tochukwu.deliveryrooopractice.data.model.NewsResponse
import com.tochukwu.deliveryrooopractice.domain.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach



@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getUseCase : GetNewsUseCase
): ViewModel() {


    private val _state = MutableStateFlow<NewsEvent>(NewsEvent.Empty)
    val state: StateFlow<NewsEvent> = _state

    sealed class NewsEvent {
        class Success(val art: List<Article>): NewsEvent()
        class Failure(val errorText: String): NewsEvent()
        object Loading : NewsEvent()
        object Empty : NewsEvent()
    }

    init{
        getNews()
    }

    fun getNews() {
        getUseCase().onEach { result ->
            when(result){
                is Resource.Error -> {
                  _state.value = NewsEvent.Failure(result.message!!)
                }
                is Resource.Loading ->{
                    _state.value = NewsEvent.Loading
                }
                is Resource.Success -> {
                    val response = result.data!!
                    _state.value = NewsEvent.Success(response as List<Article>)
                }
            }
        }
    }

}
