package com.srisuk.carwashcustomer.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.response.UserInfoResponse
import com.srisuk.carwashcustomer.model.response.HistoryResponse
import kotlinx.coroutines.launch

class ProfileViewModel(private var reposistory: AppReposistory): BaseViewModel() {
    private  val _response = MutableLiveData<UserInfoResponse>()
    val response: LiveData<UserInfoResponse>
        get() = _response
    fun userinfo(){
        launch {
            try {
                val response = reposistory.userinfo()
                _response.value=response
            }catch (e : Throwable){
                _error.value= e
            }
        }
    }
}
//ProfileViewModel