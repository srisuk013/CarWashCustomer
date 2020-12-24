package com.srisuk.carwashcustomer.presentation.choosecar

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.srisuk.carwashcustomer.ChooseMapActivity
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.model.MyCar
import com.srisuk.carwashcustomer.model.PackageCar
import com.srisuk.carwashcustomer.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_choose_car.*
import kotlinx.android.synthetic.main.activity_choose_car.iv_arrow_back
import kotlinx.android.synthetic.main.activity_choose_package.*
import kotlinx.android.synthetic.main.item_choose_car.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChooseCarActivity : BaseActivity() {
    val viewModel by viewModel<ChooseCarViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_car)

        val packages = intent.getParcelableExtra<PackageCar>("ChooseCarActivity")

        val adt = ChooseCarAdapter()
        recycler_view2.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt

        }
        viewModel.response.observe { response ->
            adt.setList(response.myCar)
        }

        adt.onClick = {
            val intent = Intent(baseContext, ChooseMapActivity::class.java).apply {
                putExtra("ChooseMapActivity",packages)
                putExtra("vehicle_registration",it.vehicleRegistration)
                putExtra("carId", it.carId)
            }
            startActivity(intent);
        }
        iv_arrow_back.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent);
        }

        viewModel.error.observeError()
        viewModel.choosecar()
    }


}

