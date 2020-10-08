package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.Brand

data class BrandCarModelResponse(
    @SerializedName("Brand")
    val brand: Brand,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Success")
    val success: Boolean
)