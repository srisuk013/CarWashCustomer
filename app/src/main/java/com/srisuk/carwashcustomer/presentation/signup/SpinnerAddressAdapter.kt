package com.srisuk.carwashcustomer.presentation.signup

import android.content.Context
import android.view.View
import com.srisuk.carwashcustomer.*
import com.srisuk.carwashcustomer.base.BaseSpinner
import kotlinx.android.synthetic.main.item_spinner_address.view.*

class GeographyAdapter(
    context: Context,
    list: MutableList<GeographyItemItem>
) : BaseSpinner<GeographyItemItem>(context, list) {

    override fun getLayout(): Int = R.layout.item_spinner_address

    override fun View.onBindViewHolder(data: GeographyItemItem) {
        tvAddress.text = data.gEONAME
    }

}

class ProvincesAdapter(
    context: Context,
    list: MutableList<ProvincesItemItem>
) : BaseSpinner<ProvincesItemItem>(context, list) {

    override fun getLayout(): Int = R.layout.item_spinner_address

    override fun View.onBindViewHolder(data: ProvincesItemItem) {
        tvAddress.text = data.pROVINCENAME
    }

}

class DistrictsAdapter(
    context: Context,
    list: MutableList<DistrictsItemItem>
) : BaseSpinner<DistrictsItemItem>(context, list) {

    override fun getLayout(): Int = R.layout.item_spinner_address

    override fun View.onBindViewHolder(data: DistrictsItemItem) {
        tvAddress.text = data.dISTRICTNAME
    }

}

class SubDistrictsAdapter(
    context: Context,
    list: MutableList<SubDistrictsItemItem>
) : BaseSpinner<SubDistrictsItemItem>(context, list) {

    override fun getLayout(): Int = R.layout.item_spinner_address

    override fun View.onBindViewHolder(data: SubDistrictsItemItem) {
        tvAddress.text = data.sUBDISTRICTNAME
    }

}
