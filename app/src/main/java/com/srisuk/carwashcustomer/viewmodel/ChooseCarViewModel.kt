package com.srisuk.carwashcustomer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.response.MyCarResponse
import kotlinx.coroutines.launch


class ChooseCarViewModel (private var reposistory: AppReposistory):BaseViewModel() {
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
