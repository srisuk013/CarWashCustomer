package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class CarmodelX(
    @SerializedName("Model_Id")
    val modelId: Int,
    @SerializedName("ModelName")
    val modelName: String
)