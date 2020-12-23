package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class PackageAllResponse(
    @SerializedName("Message")
    val message: String,
    val packageCar: List<PackageCarX>,
    val packageNames: List<PackageName>,
    @SerializedName("Success")
    val success: Boolean
)