package com.srisuk.carwashcustomer.model.response.packageall


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("Prices")
    val prices: String
)