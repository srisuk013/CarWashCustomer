package com.srisuk.carwashcustomer

import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//suspend fun FragmentActivity.getGoogleMap(): GoogleMap = suspendCoroutine { continuation ->
//    val gm = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
//    gm.getMapAsync { googleMap ->
//        continuation.resume(googleMap)
//    }
//}
