package com.srisuk.carwashcustomer.presentation.addcar

import android.content.Context
import android.view.View
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseSpinner
import com.srisuk.carwashcustomer.model.CarmodelX
import kotlinx.android.synthetic.main.item_spinner_brand.view.*

class CarModelAdapter(
    context: Context,
    list: MutableList<CarmodelX>
) : BaseSpinner<CarmodelX>(context, list) {
    override fun getLayout(): Int = R.layout.item_spinner_brand
    override fun View.onBindViewHolder(data: CarmodelX) {
        tvSpinnerBrand.text = data.modelName
    }


}