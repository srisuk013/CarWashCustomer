package com.srisuk.carwashcustomer

import com.srisuk.carwashcustomer.model.LoginRequest
import com.srisuk.carwashcustomer.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AppService {
    @POST("api/account/Login/")
    suspend fun  login(@Body login: LoginRequest):LoginResponse
}