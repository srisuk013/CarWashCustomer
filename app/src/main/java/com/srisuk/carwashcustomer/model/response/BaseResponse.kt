package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Success")
    val success: Boolean
)