package com.srisuk.carwashcustomer

import android.view.View
import com.srisuk.carwashcustomer.base.BaseRecyclerView
import com.srisuk.carwashcustomer.model.MyCar
import kotlinx.android.synthetic.main.item_choose_car.view.tv_VehicleRegistration
import kotlinx.android.synthetic.main.item_mycar.view.*

class MyCarAdapter : BaseRecyclerView<MyCar>() {
    override fun getLayout(): Int = R.layout.item_mycar

    override fun View.onBindViewHolder(data: MyCar) {
        tv_VehicleRegistration.text = data.vehicleRegistration+ "กรุงเทพมหานคร"
        tv_Brand.text = data.brand

    }
}