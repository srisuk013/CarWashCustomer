package com.srisuk.carwashcustomer

import com.srisuk.carwashcustomer.model.LoginRequest
import com.srisuk.carwashcustomer.model.LoginResponse
import retrofit2.http.Body

interface AppReposistory{
    suspend fun login(login: LoginRequest):LoginResponse
}
class AppRepositoryIml(private var api: AppService):AppReposistory{
    override suspend fun login(login: LoginRequest) :LoginResponse =api.login(login)
}