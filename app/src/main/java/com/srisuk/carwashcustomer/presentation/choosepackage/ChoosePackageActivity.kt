package com.srisuk.carwashcustomer.presentation.choosepackage

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.versionedparcelable.ParcelUtils
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.model.PackageCar
import com.srisuk.carwashcustomer.presentation.choosecar.ChooseCarActivity
import com.srisuk.carwashcustomer.presentation.main.MainActivity
import com.srisuk.carwashcustomer.util.extension.toast
import kotlinx.android.synthetic.main.activity_choose_package.*

class ChoosePackageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_package)

        val packages = intent.getParcelableExtra<PackageCar>("ChoosePackageActivity")

        if (packages != null) {
            tv_1.text = packages.packagename
            tv_2.text = packages.description
            tv_3.text = "B" + packages.price
            toast("$packages")
        }
        btn_ChoosePackage.setOnClickListener {
            val intent = Intent(baseContext, ChooseCarActivity::class.java).apply {
                putExtra("ChooseCarActivity",packages)
            }
            startActivity(intent);
        }
        iv_arrow_back.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent);
        }

    }
}
