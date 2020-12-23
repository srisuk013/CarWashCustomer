package com.srisuk.carwashcustomer.presentation.mycar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.response.MyCarResponse
import com.srisuk.carwashcustomer.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class MyCarViewModel (private var reposistory: AppReposistory): BaseViewModel(){
       private val _response = MutableLiveData<MyCarResponse>()
           val response: LiveData<MyCarResponse>
               get() = _response

           fun choosecar() {
               launch {
                   try {
                       val response = reposistory.choosecar()
                       _response.value = response
                   } catch (e: Throwable) {
                       _error.value = e
                   }
               }
           }
}