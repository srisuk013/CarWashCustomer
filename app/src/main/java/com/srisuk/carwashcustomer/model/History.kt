package com.srisuk.carwashcustomer.model


import com.google.gson.annotations.SerializedName

data class History(
    @SerializedName("Comment")
    val comment: String?=null,
    @SerializedName("FullName")
    val fullName: String?=null,
    @SerializedName("ImageProfile")
    val imageProfile: String?=null,
    @SerializedName("ImagesAfterService")
    val imagesAfterService: List<ImagesAfterService>,
    @SerializedName("ImagesBeforeService")
    val imagesBeforeService: List<ImagesBeforeService>,
    @SerializedName("JobDateTime")
    val jobDateTime: String?=null,
    @SerializedName("JobId")
    val jobId: Int,
    @SerializedName("Location")
    val location: String?=null,
    @SerializedName("OtherImagesService")
    val otherImagesService: List<OtherImagesService>,
    @SerializedName("PackageName")
    val packageName: String?=null,
    @SerializedName("Price")
    val price: String?=null,
    @SerializedName("VehicleRegistration")
    val vehicleRegistration: String?=null
)