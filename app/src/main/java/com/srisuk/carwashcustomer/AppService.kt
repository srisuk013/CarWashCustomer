package com.srisuk.carwashcustomer

import com.srisuk.carwashcustomer.model.CarModelResponse
import com.srisuk.carwashcustomer.model.request.LoginRequest
import com.srisuk.carwashcustomer.model.response.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AppService {
    @POST("api/account/Login")
    suspend fun  login(@Body login: LoginRequest): LoginResponse

    @GET("api/Customer/History")
    suspend fun history(@Query("DateBegin")DateBegin: Long?,@Query("DateEnd")DateEnd: Long?): HistoryResponse

    @GET("api/account/userinfo")
    suspend fun  userinfo(): UserInfoResponse

    @GET("api/Customer/ShowPackage")
    suspend fun showpackage(): PackageResponse

    @GET("api/Customer/ChooseCar")
    suspend fun choosecar(): MyCarResponse

    @GET("api/Customer/Province")
    suspend fun modelcar():ProvinceModelResponse

    @GET("api/Customer/ListCarInformation")
    suspend fun modelbrand():BrandCarModelResponse

    @GET("api/Customer/Model")
    suspend fun listcarmodel(@Query("brandid")BrandId :Int):CarModelResponse
}