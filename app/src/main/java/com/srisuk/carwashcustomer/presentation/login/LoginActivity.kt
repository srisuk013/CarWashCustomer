package com.srisuk.carwashcustomer.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.util.extension.hideSoftKeyboard
import com.srisuk.carwashcustomer.model.request.LoginRequest
import com.srisuk.carwashcustomer.presentation.main.MainActivity
import com.srisuk.carwashcustomer.presentation.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {
    val viewModel by viewModel<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel.response.observe {
            if (it.success) {
                val preferences = getSharedPreferences("file", Context.MODE_PRIVATE)
                preferences.edit()
                    .putString("access_token", it.token.accessToken)
                    .apply()
                val intent = Intent(baseContext, MainActivity::class.java)
                startActivity(intent);
            }

            Toast.makeText(baseContext, it.message, Toast.LENGTH_LONG).show()
        }
        viewModel.error.observeError()
        bt_sign_in.setOnClickListener {
            viewModel.login(LoginRequest(et_username.text.toString(), et_password.text.toString()))
//            val login = LoginRequest(et_username.text.toString(), et_password.text.toString())
//            Log.d(TAG, "onCreate: $login")
        }
        tv_sign_up.setOnClickListener {
            val intent=Intent(baseContext, SignUpActivity::class.java)
            startActivity(intent);
        }

        root_layout.setOnClickListener { hideSoftKeyboard() }
    }

    companion object{
        private const val TAG = "LoginActivity"
    }

}