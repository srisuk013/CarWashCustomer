package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class PackageCar(
    @SerializedName("Description")
    val description: String,
    @SerializedName("PackageId")
    val packageId: Int,
    @SerializedName("Packagename")
    val packagename: String,
    @SerializedName("Price")
    val price: String,
    @SerializedName("SizeId")
    val sizeId: Int
)