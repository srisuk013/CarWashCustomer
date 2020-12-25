package com.srisuk.carwashcustomer.presentation.booking

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.model.PackageCar
import com.srisuk.carwashcustomer.model.ServiceUsageInformation
import com.srisuk.carwashcustomer.model.request.BookingJobRequest
import com.srisuk.carwashcustomer.presentation.changpassword.ChangePasswordViewModel
import com.srisuk.carwashcustomer.presentation.main.MainActivity
import com.srisuk.carwashcustomer.util.extension.toast
import kotlinx.android.synthetic.main.activity_booking.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingActivity : BaseActivity() {
    val viewModel by viewModel<BookingViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        val packages = intent.getParcelableExtra<PackageCar>("BookingActivity")
        val vehicleRegistration=intent.getStringExtra("vehicleRegistration")
        val province=intent.getStringExtra("province")
        val carId = intent.getIntExtra("carId", 0)
        val latitude=intent.getDoubleExtra("latitude",0.0)
        val longitude=intent.getDoubleExtra("longitude",0.0)
        val mServiceUsageInformation = ServiceUsageInformation(packages?.packagename.toString()
            ,vehicleRegistration.toString(),packages?.price.toString(),province)
        if (mServiceUsageInformation!=null){
            tv_package_id.text = mServiceUsageInformation.package_name
            tv_Vehicle_registration.text = mServiceUsageInformation.vehicle_registration+" "+province
            price.text = "฿ " +  mServiceUsageInformation.price+".00"
//            toast("$mServiceUsageInformation")
        }
        viewModel.response.observe {
            Toast.makeText(baseContext, it.message, Toast.LENGTH_LONG).show()
        }
        viewModel.error.observeError()
        bt_booking.setOnClickListener {
            viewModel.booking(BookingJobRequest(
                packageId =packages?.packageId,carId=carId,longitude =longitude ,latitude =latitude
            ))
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent);
        }

    }

}

// vehicle_registration => sneck case
// vehicleRegistration => camel case
// VehicleRegistration => c#
