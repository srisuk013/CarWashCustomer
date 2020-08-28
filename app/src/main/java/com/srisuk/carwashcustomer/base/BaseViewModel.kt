package com.srisuk.carwashcustomer.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        _error.value = error
    }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + exceptionHandler + job

    protected val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable>
        get() = _error

    override fun onCleared() {
        coroutineContext.cancel()
        super.onCleared()
    }

}
