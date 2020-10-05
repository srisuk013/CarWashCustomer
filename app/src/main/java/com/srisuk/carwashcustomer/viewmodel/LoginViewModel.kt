package com.srisuk.carwashcustomer.viewmodel
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.request.LoginRequest
import com.srisuk.carwashcustomer.model.response.*
import kotlinx.coroutines.launch

class LoginViewModel(private var reposistory: AppReposistory) : BaseViewModel() {

    private  val _response = MutableLiveData<LoginResponse>()
    val response: LiveData<LoginResponse>
    get() = _response
    fun login(login: LoginRequest){
        launch {
            try {
                Log.d(TAG, "login: 1")
                val response = reposistory.login(login)
                Log.d(TAG, "login: $response")
                _response.value=response
            }catch (e : Throwable){
                _error.value= e
            }

        }

    }

    companion object{
        private const val TAG = "LoginViewModel"
    }

}