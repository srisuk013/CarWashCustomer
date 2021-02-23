package com.srisuk.carwashcustomer.presentation.booking

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.model.PackageCar
import com.srisuk.carwashcustomer.model.ServiceUsageInformation
import com.srisuk.carwashcustomer.model.UserInfo
import com.srisuk.carwashcustomer.model.request.BookingJobRequest
import com.srisuk.carwashcustomer.extension.toast
import kotlinx.android.synthetic.main.activity_booking.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingActivity : BaseActivity() {
    private var userinfo:UserInfo ? = null
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
            toast("$mServiceUsageInformation")
        }
        viewModel.response.observe {
            Toast.makeText(baseContext, userinfo.toString(), Toast.LENGTH_LONG).show()
            userinfo =it.userInfo

            Log.d(TAG, "onCreate: $it")
        }
        viewModel.error.observeError()
        bt_booking.setOnClickListener {
            viewModel.booking(BookingJobRequest(
                packageId =packages?.packageId,carId=carId,longitude =longitude ,latitude =latitude
            ))
            callApi()
        }

    }

    private fun callApi() {
//        Handler().postDelayed({
            FindEmployeeDialog().apply {

                show(supportFragmentManager, null)
//                 if (success==true){
                     setListener {
                         EmployeeInfoDialog().apply {

                             toast(userinfo.toString())

                             arguments = bundleOf(
                                 "fullName" to userinfo?.fullName,
                                 "phone" to userinfo?.phone,
                                 "image" to userinfo?.image
                             )
                             show(supportFragmentManager, null)
                         }
                     }
//                 }else{
//                     Toast.makeText(baseContext, "ไม่มีผู้ให้บริการขณะนี้", Toast.LENGTH_LONG).show()
//                 }

            }
//        }, 1_000)
    }
    companion object{
        private const val TAG = "LoginActivity"
    }

}

// vehicle_registration => sneck case
// vehicleRegistration => camel case
// VehicleRegistration => c#
