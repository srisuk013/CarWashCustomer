package com.srisuk.carwashcustomer

import android.view.View
import com.srisuk.carwashcustomer.base.BaseRecyclerView
import com.srisuk.carwashcustomer.model.PackageCar
import kotlinx.android.synthetic.main.item_home.view.*


class PackageAdapter:BaseRecyclerView<PackageCar>(){
    override fun getLayout(): Int = R.layout.item_home

    override fun View.onBindViewHolder(data: PackageCar) {
        tv_namepackage.text = data.packagename
        tv_pr.text  ="฿" +data.price+".00"
    }


}

