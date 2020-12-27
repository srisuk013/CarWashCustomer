package com.srisuk.carwashcustomer.presentation.mycar

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_choose_car.*
import kotlinx.android.synthetic.main.activity_my_car.*
import kotlinx.android.synthetic.main.activity_my_car.iv_arrow_back
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyCarActivity : BaseActivity() {
    val viewModel by viewModel<MyCarViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_car)
        val adt = MyCarAdapter()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt

        }

        viewModel.response.observe { response ->
            adt.setList(response.myCar)
        }
        viewModel.error.observeError()
        viewModel.choosecar()
        iv_arrow_back.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent);
        }
    }

}
