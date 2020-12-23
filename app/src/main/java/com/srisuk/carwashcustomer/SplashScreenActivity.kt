package com.srisuk.carwashcustomer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.srisuk.carwashcustomer.presentation.login.LoginActivity
import com.srisuk.carwashcustomer.presentation.main.MainActivity
import com.srisuk.carwashcustomer.presentation.signup.SignUpActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val token = getSharedPreferences("file", MODE_PRIVATE)
            .getString("access_token","")

        if (token.isNullOrBlank()){
            // TODO: 12/16/2020 login
            val intent= Intent(baseContext, LoginActivity::class.java)
            startActivity(intent);
        }else{
            // TODO: 12/16/2020 main
            val intent=Intent(baseContext, MainActivity::class.java)
            startActivity(intent);
        }

    }
}