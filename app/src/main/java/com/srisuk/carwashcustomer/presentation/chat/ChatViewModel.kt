package com.srisuk.carwashcustomer.presentation.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.request.ChatRequest
import com.srisuk.carwashcustomer.model.response.BaseResponse
import com.srisuk.carwashcustomer.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class ChatViewModel(private var reposistory: AppReposistory): BaseViewModel() {

       private val _response = MutableLiveData<BaseResponse>()
           val response: LiveData<BaseResponse>
               get() = _response

           fun chat(chat:ChatRequest) {
               launch {
                   try {
                       val response = reposistory.chat(chat)
                       _response.value = response
                   } catch (e: Throwable) {
                       _error.value = e
                   }
               }
           }
}