package com.srisuk.carwashcustomer.model.response.packageall


import com.google.gson.annotations.SerializedName

data class PackageName(
    @SerializedName("Name")
    val name: String
)