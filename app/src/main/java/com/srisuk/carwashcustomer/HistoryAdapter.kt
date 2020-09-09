package com.srisuk.carwashcustomer

import android.view.View
import com.srisuk.carwashcustomer.base.BaseRecyclerView
import com.srisuk.carwashcustomer.extension.setImageCircle
import com.srisuk.carwashcustomer.model.History
import kotlinx.android.synthetic.main.fragment_history.view.*
import kotlinx.android.synthetic.main.item_history.view.*

class HistoryAdapter : BaseRecyclerView<History>() {

    override fun getLayout(): Int = R.layout.item_history

    override fun View.onBindViewHolder(data: History) {
        tv_full_name.text = data.fullName
        tv_date_time.text = data.jobDateTime
        iv_photo.setImageCircle(data.imageProfile)
    }

}
