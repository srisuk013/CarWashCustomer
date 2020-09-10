package com.srisuk.carwashcustomer

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.srisuk.carwashcustomer.base.BaseFragment
import com.srisuk.carwashcustomer.extension.toast
import com.srisuk.carwashcustomer.viewmodel.PackageViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(R.layout.fragment_home) {
    private val viewModel by viewModel<PackageViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adt = PackageAdapter()
        recycler_view1.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt

        }
        viewModel.showpackage()
        viewModel.response.observe { response ->
            adt.setList(response.packageCar)

        }

        viewModel.error.observeError()

        adt.onClick = {
            Intent(context, ChoosePackageActivity::class.java).apply {
                putExtra("ChoosePackageActivity", it)
                startActivity(this)
            }
        }

    }
}

