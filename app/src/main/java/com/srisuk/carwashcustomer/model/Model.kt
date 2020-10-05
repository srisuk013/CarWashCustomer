package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("BrandId")
    val brandId: Int?=null,
    @SerializedName("BrandName")
    val brandName: String?=null,
    @SerializedName("Model_Id")
    val modelId: Int ?=null,
    @SerializedName("ModelName")
    val modelName: String?=null,
    @SerializedName("SizeId")
    val sizeId: Int?=null,
    @SerializedName("SizeName")
    val sizeName: String?=null
)