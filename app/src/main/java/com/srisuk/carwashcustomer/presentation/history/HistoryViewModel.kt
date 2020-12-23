package com.srisuk.carwashcustomer.presentation.history
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srisuk.carwashcustomer.AppReposistory
import com.srisuk.carwashcustomer.model.response.HistoryResponse
import com.srisuk.carwashcustomer.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class HistoryViewModel(private var reposistory: AppReposistory): BaseViewModel() {
    private  val _response = MutableLiveData<HistoryResponse>()
    val response: LiveData<HistoryResponse>
        get() = _response
    fun history(DateBegin: Long?,DateEnd: Long?){
        launch {
            try {
                val response = reposistory.history(DateBegin,DateEnd)
                _response.value=response
            }catch (e : Throwable){
                _error.value= e
            }
        }
    }
}