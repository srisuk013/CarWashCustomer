package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class PackageName(
    @SerializedName("Packagename")
    val packagename: String
)