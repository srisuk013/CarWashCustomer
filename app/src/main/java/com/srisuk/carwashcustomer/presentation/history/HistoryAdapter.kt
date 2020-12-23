package com.srisuk.carwashcustomer.presentation.history

import android.view.View
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseRecyclerView
import com.srisuk.carwashcustomer.util.extension.setImageCircle
import com.srisuk.carwashcustomer.model.History
import kotlinx.android.synthetic.main.item_history.view.*

class HistoryAdapter : BaseRecyclerView<History>() {

    override fun getLayout(): Int = R.layout.item_history

    override fun View.onBindViewHolder(data: History) {
        tv_full_name.text = data.fullName
        tv_date_time.text = data.jobDateTime
        iv_photo.setImageCircle(data.imageProfile)
    }

}
