package com.srisuk.carwashcustomer.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.response.PackageResponse
import com.srisuk.carwashcustomer.viewmodel.BaseViewModel
import kotlinx.coroutines.launch


class PackageViewModel (private  var reposistory: AppReposistory): BaseViewModel() {
    private val _response = MutableLiveData<PackageResponse>()
    val response: LiveData<PackageResponse>
        get() = _response

    fun showpackage() {
        launch {
            try {
                val response = reposistory.showpackage()
                _response.value = response
            } catch (e: Throwable) {
                _error.value = e
            }
        }

    }
}
