package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.MyCar

data class MyCarResponse(
    @SerializedName("Message")
    val message: String,
    @SerializedName("MyCar")
    val myCar: List<MyCar>,
    @SerializedName("Success")
    val success: Boolean
)