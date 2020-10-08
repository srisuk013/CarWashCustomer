package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName

data class ProvinceModelResponse(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Shows")
    val shows: Shows,
    @SerializedName("Success")
    val success: Boolean
)