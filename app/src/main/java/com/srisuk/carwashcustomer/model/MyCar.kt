package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class MyCar(
    @SerializedName("Brand")
    val brand: String?=null,
    @SerializedName("CarId")
    val carId: Int?=null,
    @SerializedName("VehicleRegistration")
    val vehicleRegistration: String?=null
)