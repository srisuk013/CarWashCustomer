package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class UserInfoX(
    @SerializedName("Code")
    val code: String,
    @SerializedName("FullName")
    val fullName: String,
    @SerializedName("IdCardNumber")
    val idCardNumber: String,
    @SerializedName("Image")
    val image: String,
    @SerializedName("Phone")
    val phone: String,
    @SerializedName("UserId")
    val userId: Int
)