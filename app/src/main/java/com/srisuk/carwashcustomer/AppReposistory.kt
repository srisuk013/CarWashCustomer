package com.srisuk.carwashcustomer

import com.srisuk.carwashcustomer.model.CarModelResponse
import com.srisuk.carwashcustomer.model.request.LoginRequest
import com.srisuk.carwashcustomer.model.response.*

interface AppReposistory{
    suspend fun login(login: LoginRequest): LoginResponse
    suspend fun  history(DateBegin: Long?,DateEnd: Long?): HistoryResponse
    suspend fun  userinfo(): UserInfoResponse
    suspend fun  showpackage(): PackageResponse
    suspend fun choosecar():MyCarResponse
    suspend fun modelcar():ProvinceModelResponse
    suspend fun modelbrand():BrandCarModelResponse
    suspend fun carmodel(BrandId:Int):CarModelResponse

}
class AppRepositoryIml(private var api: AppService):AppReposistory{
    override suspend fun login(login: LoginRequest) : LoginResponse =api.login(login)
    override suspend fun history(DateBegin: Long?,DateEnd: Long?): HistoryResponse =api.history(DateBegin,DateEnd)
    override suspend fun userinfo(): UserInfoResponse =api.userinfo()
    override suspend fun showpackage(): PackageResponse =api.showpackage()
    override suspend fun choosecar():MyCarResponse=api.choosecar()
    override suspend fun modelcar():ProvinceModelResponse=api.modelcar()
    override suspend fun modelbrand():BrandCarModelResponse =api.modelbrand()
    override suspend fun carmodel(BrandId:Int):CarModelResponse =api.listcarmodel(BrandId)
}
