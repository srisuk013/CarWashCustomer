package com.srisuk.carwashcustomer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.srisuk.carwashcustomer.base.onItemSelected
import kotlinx.android.synthetic.main.item_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var geography: GeographyItemItem
    private lateinit var provinces: ProvincesItemItem
    private lateinit var districts: DistrictsItemItem
    private lateinit var subDistricts: SubDistrictsItemItem
    private var zipcode: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSpinnerAddressGeography()
    }

    private fun setSpinnerAddressGeography() {
        val list = getAddressFromAssets<GeographyItem>("geography.json")
        spinnerGeography.adapter = GeographyAdapter(baseContext, list)
        spinnerGeography.onItemSelected<GeographyItemItem> {
            geography = it
            setSpinnerAddressProvinces(it.gEOID)
        }
    }

    private fun setSpinnerAddressProvinces(geoId: Int) {
        val list = getAddressFromAssets<ProvincesItem>("provinces.json")
        val filter = list.filter { it.gEOID == geoId } as MutableList
        spinnerProvinces.adapter = ProvincesAdapter(baseContext, filter)
        spinnerProvinces.onItemSelected<ProvincesItemItem> {
            provinces = it
            setSpinnerAddressDistricts(it.pROVINCEID)
        }
    }

    private fun setSpinnerAddressDistricts(provinceId: Int) {
        val list = getAddressFromAssets<DistrictsItem>("districts.json")
        val filter = list.filter { it.pROVINCEID == provinceId } as MutableList
        spinnerDistricts.adapter = DistrictsAdapter(baseContext, filter)
        spinnerDistricts.onItemSelected<DistrictsItemItem> {
            districts = it
            setSpinnerAddressSubDistricts(it.dISTRICTID)
        }
    }

    private fun setSpinnerAddressSubDistricts(districtId: Int) {
        val list = getAddressFromAssets<SubDistrictsItem>("subDistricts.json")
        val filter = list.filter { it.dISTRICTID == districtId } as MutableList
        spinnerSubDistricts.adapter = SubDistrictsAdapter(baseContext, filter)
        spinnerSubDistricts.onItemSelected<SubDistrictsItemItem> {
            subDistricts = it
            setSpinnerAddressZipcodes(it.sUBDISTRICTID)
        }
    }

    private fun setSpinnerAddressZipcodes(subDistrictId: Int) {
        val list = getAddressFromAssets<ZipcodesItem>("zipcodes.json")
        val find = list.find { it.sUBDISTRICTID.toInt() == subDistrictId }
        zipcode = find?.zIPCODE

        showFullAddress()
    }

    private fun showFullAddress() {
        val address = "$zipcode"
        text.text=address
    }
}