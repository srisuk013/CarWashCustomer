package com.srisuk.carwashcustomer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseLocationActivity
import com.srisuk.carwashcustomer.extension.animateCamera
import com.srisuk.carwashcustomer.util.extension.awaitLastLocation
import com.srisuk.carwashcustomer.util.extension.locationFlow
import kotlinx.android.synthetic.main.activity_choose_map.*
import kotlinx.android.synthetic.main.item_map.*
import kotlinx.coroutines.launch

class ChooseMapActivity : BaseLocationActivity() {
    private var mGoogleMap: GoogleMap? = null
    private var mIsFlagMoveCamera: Boolean = true
    private var mMarkerMyLocation: Marker? = null
    private var mMarkerCustomer: Marker? = null

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_map)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setToolbar(toolbar)

        val locationProviderClient = LocationServices
            .getFusedLocationProviderClient(this)

        map_fragment.onCreate(savedInstanceState)


        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            launch {
                googleMap.isMyLocationEnabled = true
                googleMap.setMinZoomPreference(12F)
                googleMap.setMaxZoomPreference(16F)

                val location = locationProviderClient.awaitLastLocation()
                val latLng = LatLng(location.latitude, location.longitude)
                val cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 14F)
                googleMap.animateCamera(cameraUpdate)
            }
        }


//            locationProviderClient
//                .locationFlow()
//                .onEach { onLocationChange(it) }
//                .catch { requireView().snackbar(it.message) }
//                .launchIn(this)

    }
}

