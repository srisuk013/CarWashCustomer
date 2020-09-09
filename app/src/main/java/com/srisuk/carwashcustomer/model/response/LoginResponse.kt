package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.Token
import com.srisuk.carwashcustomer.model.UserInfo

data class LoginResponse(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Success")
    val success: Boolean,
    @SerializedName("Token")
    val token: Token,
    @SerializedName("UserInfo")
    val userInfo: UserInfo
)