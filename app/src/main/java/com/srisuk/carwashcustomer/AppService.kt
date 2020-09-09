package com.srisuk.carwashcustomer

import com.srisuk.carwashcustomer.model.response.UserInfoResponse
import com.srisuk.carwashcustomer.model.response.HistoryResponse
import com.srisuk.carwashcustomer.model.request.LoginRequest
import com.srisuk.carwashcustomer.model.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AppService {
    @POST("api/account/Login/")
    suspend fun  login(@Body login: LoginRequest): LoginResponse

    @GET("api/Customer/History")
    suspend fun history(@Query("DateBegin")DateBegin: Long?,@Query("DateEnd")DateEnd: Long?): HistoryResponse

    @GET("api/account/userinfo")
    suspend fun  userinfo(): UserInfoResponse
}