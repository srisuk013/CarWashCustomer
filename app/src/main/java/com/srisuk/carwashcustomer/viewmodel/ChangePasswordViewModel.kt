package com.srisuk.carwashcustomer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.request.ChangePasswordRequest
import com.srisuk.carwashcustomer.model.response.BaseResponse
import kotlinx.coroutines.launch

class ChangePasswordViewModel(private var reposistory:AppReposistory):BaseViewModel() {
       private val _response = MutableLiveData<BaseResponse>()
           val response: MutableLiveData<BaseResponse>
               get() = _response

           fun changepassword(change: ChangePasswordRequest) {
               launch {
                   try {
                       val response = reposistory.changepassword(change)
                       _response.value = response
                   } catch (e: Throwable) {
                       _error.value = e
                   }
               }
           }

}