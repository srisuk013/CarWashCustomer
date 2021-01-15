package com.srisuk.carwashcustomer.presentation.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.srisuk.carwashcustomer.R
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

        val bundle = arguments?.getString("employee","0")
        val bundle1 = arguments?.getString("employee","0")
        tv_full_name_emp.text=bundle


        bt_ok_emp.setOnClickListener {
            dialog?.dismiss()
        }
    }

}
