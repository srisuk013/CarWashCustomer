package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class ImagesBeforeService(
    @SerializedName("Image")
    val image: String,
    @SerializedName("ImageId")
    val imageId: Int
)