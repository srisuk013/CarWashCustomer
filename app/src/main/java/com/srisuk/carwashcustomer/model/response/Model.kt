package com.srisuk.carwashcustomer.model.response


import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("ProvinceId")
    val provinceId: Int,
    @SerializedName("ProvinceName")
    val provinceName: String
)