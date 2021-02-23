package com.srisuk.carwashcustomer.presentation.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.util.extension.setImageCircle
import kotlinx.android.synthetic.main.dialog_employee_info.*

class EmployeeInfoDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog_MinWidth)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_employee_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fullName = arguments?.getString("fullName","")
        val phone = arguments?.getString("phone","")
        val image = arguments?.getString("image","")
        tv_full_name_emp.text=fullName
        tv_phone_emp.text=phone
        iv_photo_emp.setImageCircle(image)

        bt_ok_emp.setOnClickListener {
            dialog?.dismiss()
        }
    }

}
