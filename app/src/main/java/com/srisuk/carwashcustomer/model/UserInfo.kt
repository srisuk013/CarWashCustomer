package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("Code")
    val code: String?=null,
    @SerializedName("FullName")
    val fullName: String?=null,
    @SerializedName("IdCardNumber")
    val idCardNumber: String?=null,
    @SerializedName("Image")
    val image: String?=null,
    @SerializedName("Phone")
    val phone: String?=null,
    @SerializedName("UserId")
    val userId: Int
)