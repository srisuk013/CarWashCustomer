package com.srisuk.carwashcustomer.model.response.packageall


import com.google.gson.annotations.SerializedName
import com.srisuk.carwashcustomer.model.response.packageall.PackageName
import com.srisuk.carwashcustomer.model.response.packageall.Price

data class PackageAllResponse(
    @SerializedName("Message")
    val message: String,
    val packageNames: List<PackageName>,
    val price: List<Price>,
    @SerializedName("Success")
    val success: Boolean
)