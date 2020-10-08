package com.srisuk.carwashcustomer

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.base.onItemSelected
import com.srisuk.carwashcustomer.model.ModelBrand
import com.srisuk.carwashcustomer.model.response.Model
import com.srisuk.carwashcustomer.viewmodel.AddMyCarViewModel
import kotlinx.android.synthetic.main.activity_add_my_car.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddMyCarActivity : BaseActivity() {
    val viewModel by viewModel<AddMyCarViewModel>()
    private lateinit var provinces: Model
    private lateinit var Brandcar: ModelBrand


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_my_car)
        viewModel.response.observe { response ->
            spinnerProvince.adapter = ProvinceAdapter(
                baseContext,
                response.shows.models as MutableList<Model>
            )
            Log.d(TAG, "onCreate: ${response.shows.models}")
        }
        viewModel.response1.observe {
            spinnerBrand.adapter = BrandAdapter(baseContext, it.brand.models)
        }

        viewModel.error.observeError()
        viewModel.modelcar()
        viewModel.modelbrand()

        viewModel.response2 .observe {
            spinnerModel.adapter = CarModelAdapter(baseContext,it.carmodel.carmodels)
        }
        spinnerProvince.onItemSelected<Model> {
            provinces = it
            Toast.makeText(baseContext, it.provinceId.toString(), Toast.LENGTH_LONG).show()
        }
        spinnerBrand.onItemSelected<ModelBrand> {
            Brandcar = it
            Toast.makeText(baseContext, it.brandId.toString(), Toast.LENGTH_LONG).show()
            viewModel.listcarmodel(it.brandId)
        }

    }

    companion object {
        private const val TAG = "AddMyCarActivity"
    }

}