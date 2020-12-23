package com.srisuk.carwashcustomer.presentation.signup

import com.google.gson.annotations.SerializedName

class GeographyItem : ArrayList<GeographyItemItem>()

data class GeographyItemItem(
    @SerializedName("GEO_ID") val gEOID: Int,
    @SerializedName("GEO_NAME") val gEONAME: String
)

class ProvincesItem : ArrayList<ProvincesItemItem>()

data class ProvincesItemItem(
    @SerializedName("GEO_ID") val gEOID: Int,
    @SerializedName("PROVINCE_CODE") val pROVINCECODE: String,
    @SerializedName("PROVINCE_ID") val pROVINCEID: Int,
    @SerializedName("PROVINCE_NAME") val pROVINCENAME: String
)

class DistrictsItem : ArrayList<DistrictsItemItem>()

data class DistrictsItemItem(
    @SerializedName("DISTRICT_CODE") val dISTRICTCODE: String,
    @SerializedName("DISTRICT_ID") val dISTRICTID: Int,
    @SerializedName("DISTRICT_NAME") val dISTRICTNAME: String,
    @SerializedName("GEO_ID") val gEOID: Int,
    @SerializedName("PROVINCE_ID") val pROVINCEID: Int
)

class SubDistrictsItem : ArrayList<SubDistrictsItemItem>()

data class SubDistrictsItemItem(
    @SerializedName("DISTRICT_ID") val dISTRICTID: Int,
    @SerializedName("GEO_ID") val gEOID: Int,
    @SerializedName("PROVINCE_ID") val pROVINCEID: Int,
    @SerializedName("SUB_DISTRICT_CODE") val sUBDISTRICTCODE: String,
    @SerializedName("SUB_DISTRICT_ID") val sUBDISTRICTID: Int,
    @SerializedName("SUB_DISTRICT_NAME") val sUBDISTRICTNAME: String
)

class ZipcodesItem : ArrayList<ZipcodesItemItem>()

data class ZipcodesItemItem(
    @SerializedName("DISTRICT_ID") val dISTRICTID: String,
    @SerializedName("PROVINCE_ID") val pROVINCEID: String,
    @SerializedName("SUB_DISTRICT_CODE") val sUBDISTRICTCODE: String,
    @SerializedName("SUB_DISTRICT_ID") val sUBDISTRICTID: String,
    @SerializedName("ZIPCODE") val zIPCODE: String,
    @SerializedName("ZIPCODE_ID") val zIPCODEID: Int
)
