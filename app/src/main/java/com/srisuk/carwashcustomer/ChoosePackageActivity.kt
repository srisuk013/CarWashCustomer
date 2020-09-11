package com.srisuk.carwashcustomer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srisuk.carwashcustomer.extension.toast
import com.srisuk.carwashcustomer.model.PackageCar
import kotlinx.android.synthetic.main.activity_choose_package.*

class ChoosePackageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_package)

        val packageCar = intent.getParcelableExtra<PackageCar>("ChoosePackageActivity")
        if (packageCar != null) {
            tv_1.text =packageCar.packagename
            tv_2.text =packageCar.description
            tv_3.text ="B"+packageCar.price
        }
     btn_ChoosePackage.setOnClickListener {
          val intent = Intent(baseContext, ChooseCarActivity::class.java)
         startActivity(intent);
     }
    }
}