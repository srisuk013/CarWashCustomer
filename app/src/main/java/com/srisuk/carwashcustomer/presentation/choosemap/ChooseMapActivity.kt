package com.srisuk.carwashcustomer.presentation.choosemap

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseLocationActivity
import com.srisuk.carwashcustomer.model.PackageCar
import com.srisuk.carwashcustomer.model.request.BookingJobRequest
import com.srisuk.carwashcustomer.presentation.booking.BookingActivity
import com.srisuk.carwashcustomer.presentation.choosecar.ChooseCarActivity
import com.srisuk.carwashcustomer.util.extension.awaitLastLocation
import com.srisuk.carwashcustomer.util.extension.toast
import kotlinx.android.synthetic.main.activity_choose_map.*
import kotlinx.android.synthetic.main.activity_choose_map.iv_arrow_back
import kotlinx.android.synthetic.main.item_map.*
import kotlinx.coroutines.launch

class ChooseMapActivity : BaseLocationActivity() {
    var mBookingJobRequest: BookingJobRequest? = null

    private var mGoogleMap: GoogleMap? = null
    private var mIsFlagMoveCamera: Boolean = true
    private var mMarkerMyLocation: Marker? = null
    private var mMarkerCustomer: Marker? = null

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_map)

        val packages = intent.getParcelableExtra<PackageCar>("ChooseMapActivity")
        val carId = intent.getIntExtra("carId", 0)
        val vehicleRegistration=intent.getStringExtra("vehicleRegistration")
        val province=intent.getStringExtra("province")
        mBookingJobRequest = BookingJobRequest(packageId = packages?.packageId, carId = carId)

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

                setMarkerChooseMap(latLng, googleMap)

                mBookingJobRequest = mBookingJobRequest?.copy(
                    latitude = location.latitude,
                    longitude = location.longitude
                )
            }
        }
        iv_arrow_back.setOnClickListener {
            val intent = Intent(baseContext, ChooseCarActivity::class.java)
            startActivity(intent);
        }

        mapFragment.getMapAsync { googleMap ->
            googleMap.setOnMapClickListener { latLng ->
                mBookingJobRequest = mBookingJobRequest?.copy(
                    latitude = latLng.latitude,
                    longitude = latLng.longitude
                )
                setMarkerChooseMap(latLng, googleMap)
            }
        }

        bt_choose_location.setOnClickListener {
            val intent = Intent(baseContext, BookingActivity::class.java).apply {
                putExtra("BookingActivity", packages)
                putExtra("vehicleRegistration", vehicleRegistration)
                putExtra("carId", carId)
                putExtra("province", province)
                putExtra("latitude", mBookingJobRequest!!.latitude)
                putExtra("longitude", mBookingJobRequest!!.longitude)
            }
            startActivity(intent);
        }
    }

    private fun setMarkerChooseMap(latLng: LatLng, googleMap: GoogleMap) {
        mMarkerCustomer?.remove()
        val marker = MarkerOptions().apply {
            position(latLng)
            icon(BitmapDescriptorFactory.defaultMarker())
        }
        mMarkerCustomer = googleMap.addMarker(marker)
    }

}

