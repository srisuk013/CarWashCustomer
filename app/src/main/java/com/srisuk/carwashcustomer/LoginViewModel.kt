package com.srisuk.carwashcustomer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.base.BaseViewModel
import com.srisuk.carwashcustomer.model.request.LoginRequest
import com.srisuk.carwashcustomer.model.response.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private var reposistory: AppReposistory) : BaseViewModel() {

    private  val _response = MutableLiveData<LoginResponse>()
    val response: LiveData<LoginResponse>
    get() = _response
    fun login(login: LoginRequest){
        launch {
            try {
                val response = reposistory.login(login)
                _response.value=response
            }catch (e : Throwable){
                _error.value= e
            }
        }
    }
}