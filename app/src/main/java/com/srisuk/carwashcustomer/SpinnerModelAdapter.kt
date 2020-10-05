package com.srisuk.carwashcustomer

import android.content.Context
import android.view.View
import com.srisuk.carwashcustomer.base.BaseSpinner
import com.srisuk.carwashcustomer.model.Model
import kotlinx.android.synthetic.main.item_spinner_brand.view.*

class ShowsAdapter(
    context: Context,
    list: MutableList<Model>
) : BaseSpinner<Model>(context, list) {

    override fun getLayout(): Int = R.layout.item_spinner_brand
    override fun View.onBindViewHolder(data: Model) {
        tvSpinnerBrand.text = data.brandName
    }


}

