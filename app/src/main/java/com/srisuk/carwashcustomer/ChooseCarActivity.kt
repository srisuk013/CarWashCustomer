package com.srisuk.carwashcustomer

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.viewmodel.ChooseCarViewModel
import kotlinx.android.synthetic.main.activity_choose_car.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChooseCarActivity : BaseActivity() {
    val viewModel by viewModel<ChooseCarViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_car)
        val adt = ChooseCarAdapter()
        recycler_view2.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt

        }

        viewModel.response.observe { response ->
            adt.setList(response.myCar)
        }
        viewModel.error.observeError()
        viewModel.choosecar()

    }
}

