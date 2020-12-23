package com.srisuk.carwashcustomer.presentation.changpassword

import android.os.Bundle
import android.widget.Toast
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.model.request.ChangePasswordRequest
import kotlinx.android.synthetic.main.activity_change_password.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChangePasswordActivity : BaseActivity() {
    val viewModel by viewModel<ChangePasswordViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        viewModel.response.observe {
            Toast.makeText(baseContext, it.message, Toast.LENGTH_LONG).show()

        }
        viewModel.error.observeError()
        btn_Confirm.setOnClickListener {
            viewModel.changepassword(
                ChangePasswordRequest(
                    edt_OldPassword.text.toString(),
                    edt_NewPassword.text.toString()
                )
            )
        }

    }

    companion object {
        private const val TAG = "ChangePasswordActivity"

    }
}