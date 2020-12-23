package com.srisuk.carwashcustomer.presentation.packageall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.PackageAllResponse
import com.srisuk.carwashcustomer.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class PackageAllViewModel(private var reposistory: AppReposistory): BaseViewModel() {
       private val _response = MutableLiveData<PackageAllResponse>()
           val response: LiveData<PackageAllResponse>
               get() = _response

           fun packageall() {
               launch {
                   try {
                       val response = reposistory.packageall()
                       _response.value = response
                   } catch (e: Throwable) {
                       _error.value = e
                   }
               }
           }

}