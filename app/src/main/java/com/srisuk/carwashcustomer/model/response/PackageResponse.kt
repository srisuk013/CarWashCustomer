package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.PackageCar

data class PackageResponse(
    @SerializedName("Message")
    val message: String,
    val packageCar: List<PackageCar>,
    @SerializedName("Success")
    val success: Boolean
)