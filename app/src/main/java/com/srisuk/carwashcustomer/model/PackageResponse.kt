package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class PackageResponse(
    @SerializedName("Message")
    val message: String,
    val packageCar: List<PackageCar>,
    @SerializedName("Success")
    val success: Boolean
)