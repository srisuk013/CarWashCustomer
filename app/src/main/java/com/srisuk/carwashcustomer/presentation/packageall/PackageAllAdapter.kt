package com.srisuk.carwashcustomer.presentation.packageall

import android.view.View
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseRecyclerView
import com.srisuk.carwashcustomer.model.response.packageall.PackageName
import kotlinx.android.synthetic.main.item_packageall.view.*

class PackageAllAdapter : BaseRecyclerView<PackageName>() {
    override fun getLayout(): Int = R.layout.item_packageall
    override fun View.onBindViewHolder(data: PackageName) {


             tv_namepackageall.text = data.name


//        text_s.text = data.pa
        /* text_s.text  ="฿" +data.price+".00"
         text_m.text ="฿" +data.price+".00"*/
    }
}
/*class PackageAllAdapter: BaseRecyclerView<PackageName>() {
    override fun getLayout(): Int = R.layout.item_packageall
    override fun View.onBindViewHolder(data: PackageName) {
        tv_namepackageall.text = data.packagename

    }
}*/
