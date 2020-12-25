package com.srisuk.carwashcustomer.presentation.booking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.request.BookingJobRequest
import com.srisuk.carwashcustomer.model.response.BaseResponse
import com.srisuk.carwashcustomer.model.response.MyCarResponse
import com.srisuk.carwashcustomer.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class BookingViewModel(private  var reposistory: AppReposistory): BaseViewModel() {
    private val _response = MutableLiveData<BaseResponse>()
    val response: LiveData<BaseResponse>
        get() = _response

    fun booking(booking:BookingJobRequest) {
        launch {
            try {
                val response = reposistory.booking(booking)
                _response.value = response
            } catch (e: Throwable) {
                _error.value = e
            }
        }
    }
}
