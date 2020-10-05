package com.srisuk.carwashcustomer

import android.content.Context
import com.google.gson.Gson
import java.io.InputStream

inline fun <reified T> Context.getAddressFromAssets(fileName: String): T {
    val `is`: InputStream = assets.open(fileName)
    val size: Int = `is`.available()
    val buffer = ByteArray(size)
    `is`.read(buffer)
    `is`.close()
    val jsonString = String(buffer, Charsets.UTF_8)
    return Gson().fromJson(jsonString, T::class.java)
}
