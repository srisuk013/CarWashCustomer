package com.srisuk.carwashcustomer.model.response

import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.UserInfo

data class BaseUserInfoResponse(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Success")
    val success: Boolean,
    @SerializedName("UserInfo")
    val userInfo: UserInfo

)
