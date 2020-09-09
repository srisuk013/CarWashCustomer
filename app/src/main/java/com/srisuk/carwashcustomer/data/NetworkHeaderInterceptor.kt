package com.srisuk.carwashcustomer.data

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class NetworkHeaderInterceptor(
    private val context: Context,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val preferences = context.getSharedPreferences("file", Context.MODE_PRIVATE)
        val accessToken = preferences.getString("access_token", "").orEmpty()
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", accessToken)
            .build()

        return chain.proceed(request)
    }

}
