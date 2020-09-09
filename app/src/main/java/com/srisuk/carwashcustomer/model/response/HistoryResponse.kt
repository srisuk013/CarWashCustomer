package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.History

data class HistoryResponse(
    @SerializedName("Histories")
    val histories: List<History>,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Success")
    val success: Boolean
)