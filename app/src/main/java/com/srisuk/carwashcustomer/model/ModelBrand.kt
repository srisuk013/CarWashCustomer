package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class ModelBrand(
    @SerializedName("BrandId")
    val brandId: Int,
    @SerializedName("BrandName")
    val brandName: String
)