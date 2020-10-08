package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class CarModelResponse(
    @SerializedName("Carmodel")
    val carmodel: Carmodel,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Success")
    val success: Boolean
)