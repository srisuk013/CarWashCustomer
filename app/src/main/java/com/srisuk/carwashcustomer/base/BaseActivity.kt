package com.srisuk.carwashcustomer.base

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.util.extension.toast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {


    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, err ->
        toast("BaseFragment : exceptionHandler ${err.message}", Toast.LENGTH_LONG)
    }


    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + exceptionHandler

    override fun onDestroy() {
        coroutineContext.cancel()
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()
        if (!hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
        }
    }

    private fun hasPermission(permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            recreate()
        }
    }


    protected inline fun <reified T> LiveData<T>.observe(crossinline onNext: (T) -> Unit) {
        observe(this@BaseActivity, { onNext(it) })
    }

    protected fun LiveData<Throwable>.observeError() {
        observe(this@BaseActivity, {
            it.printStackTrace()
            Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
        })
    }
    protected fun setToolbar(toolbar: Toolbar) {
        toolbar.title = ""
        setSupportActionBar(toolbar)
    }
    protected fun dialogContactAdmin(
        @StringRes title: Int = R.string.contact_admin,
        @StringRes message: Int = R.string.contact_admin_message,
        contactAdmin: () -> Unit
    ) = AlertDialog.Builder(this).apply {
        setTitle(title)
        setMessage(message)
        setPositiveButton(android.R.string.ok) { _, _ ->
            contactAdmin.invoke()
        }
        setNegativeButton(android.R.string.cancel) { dialog, _ ->
            dialog.dismiss()
        }
        setCancelable(false)
        show()
    }
    protected fun dialogLogout(
        @StringRes title: Int = R.string.logout,
        @StringRes message: Int = R.string.do_you_really_want_to_log_out,
        logout: () -> Unit
    ) = AlertDialog.Builder(this).apply {
        setTitle(title)
        setMessage(message)
        setPositiveButton(android.R.string.cancel) { dialog, _ ->
            dialog.dismiss()
        }
        setNegativeButton(android.R.string.ok) { _, _ ->
            logout.invoke()
        }
        setCancelable(false)
        show()
    }

}
