package com.srisuk.carwashcustomer

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.base.onItemSelected
import com.srisuk.carwashcustomer.model.Model
import com.srisuk.carwashcustomer.model.response.ModelCarResponse
import com.srisuk.carwashcustomer.viewmodel.AddMyCarViewModel
import kotlinx.android.synthetic.main.activity_add_my_car.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddMyCarActivity : BaseActivity() {
    val viewModel by viewModel<AddMyCarViewModel>()
    private lateinit var provinces:Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_my_car)
        viewModel.response.observe {response->
            spinnerBrand.adapter = ShowsAdapter(baseContext,response.shows.models)
            Log.d(TAG, "onCreate: ${response.shows.models}")
        }
        viewModel.error.observeError()
        viewModel.modelcar()

        spinnerBrand.onItemSelected<Model> {
            provinces = it
            Toast.makeText(baseContext, it.brandId.toString(), Toast.LENGTH_LONG).show()

        }
    }

    companion object{
        private const val TAG = "AddMyCarActivity"
    }

}