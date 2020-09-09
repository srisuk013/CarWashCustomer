package com.srisuk.carwashcustomer

import com.srisuk.carwashcustomer.model.response.HistoryResponse
import com.srisuk.carwashcustomer.model.request.LoginRequest
import com.srisuk.carwashcustomer.model.response.LoginResponse

interface AppReposistory{
    suspend fun login(login: LoginRequest): LoginResponse
    suspend fun  history(DateBegin: Long?,DateEnd: Long?): HistoryResponse
}
class AppRepositoryIml(private var api: AppService):AppReposistory{
    override suspend fun login(login: LoginRequest) : LoginResponse =api.login(login)
    override suspend fun history(DateBegin: Long?,DateEnd: Long?): HistoryResponse =api.history(DateBegin,DateEnd)
}
