package com.srisuk.carwashcustomer.presentation.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.srisuk.carwashcustomer.presentation.profile.ProfileFragment
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.extension.startActivity
import com.srisuk.carwashcustomer.extension.startActivityActionDial
import com.srisuk.carwashcustomer.extension.toast
import com.srisuk.carwashcustomer.presentation.changpassword.ChangePasswordActivity
import com.srisuk.carwashcustomer.presentation.history.HistoryFragment
import com.srisuk.carwashcustomer.presentation.home.HomeFragment
import com.srisuk.carwashcustomer.presentation.mycar.MyCarActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(navListener)
        if (savedInstanceState == null)
            replaceFragment(HomeFragment())

        toolbar.title = ""
        setSupportActionBar(toolbar)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            fragment
        ).commit()
    }

    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_history -> HistoryFragment()
                else -> ProfileFragment()
            }
            replaceFragment(selectedFragment)
            true
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
           // R.id.option_change_mycar -> toast("option_change_mycar")
            R.id.option_change_mycar ->startActivity<MyCarActivity>()
//           R.id.option_change_profile -> startActivity<ChangeP>()
            R.id.option_change_password -> startActivity<ChangePasswordActivity>()
            R.id.option_contact_admin -> dialogContactAdmin { startActivityActionDial() }
//          R.id.option_logout -> dialogLogout { viewModel.callLogout() }
        }
        return super.onOptionsItemSelected(item)
    }

}