package com.srisuk.carwashcustomer

import android.view.View
import com.srisuk.carwashcustomer.base.BaseRecyclerView
import com.srisuk.carwashcustomer.model.MyCar
import kotlinx.android.synthetic.main.item_choose_car.view.*


class ChooseCarAdapter:BaseRecyclerView<MyCar>() {
    override fun getLayout(): Int =R.layout.item_choose_car
    override fun View.onBindViewHolder(data: MyCar) {
        tv_VehicleRegistration.text = data.vehicleRegistration
    }


}


