package com.srisuk.carwashcustomer.presentation.booking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.model.PackageCar
import com.srisuk.carwashcustomer.model.ServiceUsageInformation
import com.srisuk.carwashcustomer.util.extension.toast
import kotlinx.android.synthetic.main.activity_booking.*

class BookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        val packages = intent.getParcelableExtra<PackageCar>("BookingActivity")
        val vehicleRegistration=intent.getStringExtra("vehicleRegistration")
        val province=intent.getStringExtra("province")
        val mServiceUsageInformation = ServiceUsageInformation(packages?.packagename.toString()
            ,vehicleRegistration.toString(),packages?.price.toString(),province)

        if (mServiceUsageInformation!=null){
            tv_package_id.text = mServiceUsageInformation.package_name
            tv_Vehicle_registration.text = mServiceUsageInformation.vehicle_registration+" "+province
            price.text = "฿ " +  mServiceUsageInformation.price+".00"
            toast("$mServiceUsageInformation")
        }
    }
}

// vehicle_registration => sneck case
// vehicleRegistration => camel case
// VehicleRegistration => c#
