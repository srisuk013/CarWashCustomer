package com.srisuk.carwashcustomer.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PackageCar(
    @SerializedName("Description")
    val description: String?=null,
    @SerializedName("PackageId")
    val packageId: Int?=null,
    @SerializedName("Packagename")
    val packagename: String?=null,
    @SerializedName("Price")
    val price: String?=null,
    @SerializedName("SizeId")
    val sizeId: Int?=null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeValue(packageId)
        parcel.writeString(packagename)
        parcel.writeString(price)
        parcel.writeValue(sizeId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PackageCar> {
        override fun createFromParcel(parcel: Parcel): PackageCar {
            return PackageCar(parcel)
        }

        override fun newArray(size: Int): Array<PackageCar?> {
            return arrayOfNulls(size)
        }
    }
}