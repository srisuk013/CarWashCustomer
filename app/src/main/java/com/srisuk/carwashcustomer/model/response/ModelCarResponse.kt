package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.Shows

data class ModelCarResponse(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Shows")
    val shows: Shows,
    @SerializedName("Success")
    val success: Boolean
)