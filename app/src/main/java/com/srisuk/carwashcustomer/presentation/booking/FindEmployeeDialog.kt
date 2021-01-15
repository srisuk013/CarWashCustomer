package com.srisuk.carwashcustomer.presentation.booking

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.srisuk.carwashcustomer.R
import kotlinx.android.synthetic.main.dialog_find_employee.*

class FindEmployeeDialog : DialogFragment() {

    private var listener: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog_MinWidth)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_find_employee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            dialog?.dismiss()
            listener?.invoke()
        }, 10_000)

        bt_cancel.setOnClickListener {
            dialog?.dismiss()
        }
    }

    fun setListener(listener: (() -> Unit)) {
        this.listener = listener
    }

}
