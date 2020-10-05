package com.srisuk.carwashcustomer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.response.ModelCarResponse
import kotlinx.coroutines.launch

class AddMyCarViewModel(private var reposistory: AppReposistory):BaseViewModel() {
       private val _response = MutableLiveData<ModelCarResponse>()
           val response: LiveData<ModelCarResponse>
               get() = _response

           fun modelcar() {
               launch {
                   try {
                       val response = reposistory.modelcar()
                       _response.value = response
                   } catch (e: Throwable) {
                       _error.value = e
                   }
               }
           }
}