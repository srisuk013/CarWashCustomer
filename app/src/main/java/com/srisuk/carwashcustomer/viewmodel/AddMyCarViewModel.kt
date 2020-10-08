package com.srisuk.carwashcustomer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.CarModelResponse
import com.srisuk.carwashcustomer.model.response.BrandCarModelResponse
import com.srisuk.carwashcustomer.model.response.PackageResponse
import com.srisuk.carwashcustomer.model.response.ProvinceModelResponse
import kotlinx.coroutines.launch

class AddMyCarViewModel(private var reposistory: AppReposistory) : BaseViewModel() {
    private val _response = MutableLiveData<ProvinceModelResponse>()
    val response: LiveData<ProvinceModelResponse>
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
    private val _response1 = MutableLiveData<BrandCarModelResponse>()
    val response1: LiveData<BrandCarModelResponse>
    get() = _response1
    fun modelbrand(){
        launch {
            try{
                val response=reposistory.modelbrand()
                _response1.value= response
            }catch (e:Throwable){
                _error.value =e
            }
        }
    }
       private val _response2 = MutableLiveData<CarModelResponse>()
           val response2: LiveData<CarModelResponse>
               get() = _response2

           fun listcarmodel(BrandId:Int) {
               launch {
                   try {
                       val response = reposistory.carmodel(BrandId)
                       _response2.value = response
                   } catch (e: Throwable) {
                       _error.value = e
                   }
               }
           }
}