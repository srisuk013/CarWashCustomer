package com.srisuk.carwashcustomer.di

import com.srisuk.carwashcustomer.*
import com.srisuk.carwashcustomer.data.NetworkHeaderInterceptor
import com.srisuk.carwashcustomer.presentation.addcar.AddMyCarViewModel
import com.srisuk.carwashcustomer.presentation.booking.BookingActivity
import com.srisuk.carwashcustomer.presentation.booking.BookingViewModel
import com.srisuk.carwashcustomer.presentation.changpassword.ChangePasswordViewModel
import com.srisuk.carwashcustomer.presentation.chat.ChatViewModel
import com.srisuk.carwashcustomer.presentation.choosecar.ChooseCarViewModel
import com.srisuk.carwashcustomer.presentation.history.HistoryViewModel
import com.srisuk.carwashcustomer.presentation.home.PackageViewModel
import com.srisuk.carwashcustomer.presentation.login.LoginViewModel
import com.srisuk.carwashcustomer.presentation.mycar.MyCarViewModel
import com.srisuk.carwashcustomer.presentation.packageall.PackageAllViewModel
import com.srisuk.carwashcustomer.presentation.profile.ProfileViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<Interceptor> { NetworkHeaderInterceptor(get()) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://sncarwash.azurewebsites.net/")
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<AppService> { get<Retrofit>().create(AppService::class.java) }
    single<AppReposistory> { AppRepositoryIml(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { PackageViewModel(get()) }
    viewModel { ChooseCarViewModel(get()) }
    viewModel { MyCarViewModel(get ()) }
    viewModel { AddMyCarViewModel(get()) }
    viewModel { ChangePasswordViewModel(get()) }
    viewModel { PackageAllViewModel(get()) }
    viewModel { BookingViewModel (get())}
    viewModel { ChatViewModel(get ()) }
}