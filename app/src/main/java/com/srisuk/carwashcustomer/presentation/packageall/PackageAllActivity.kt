package com.srisuk.carwashcustomer.presentation.packageall

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_package_all.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PackageAllActivity : BaseActivity() {
    val viewModel by viewModel<PackageAllViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_all)
        val adt = PackageAllAdapter()
        recycler_view1.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt

        }

        viewModel.response.observe { response ->
            adt.setList(response.packageNames)
        }
        viewModel.error.observeError()
        viewModel.packageall()

    }
}