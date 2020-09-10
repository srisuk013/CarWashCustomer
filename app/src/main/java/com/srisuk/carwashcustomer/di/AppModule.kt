package com.srisuk.carwashcustomer.di

import com.srisuk.carwashcustomer.*
import com.srisuk.carwashcustomer.data.NetworkHeaderInterceptor
import com.srisuk.carwashcustomer.viewmodel.HistoryViewModel
import com.srisuk.carwashcustomer.viewmodel.LoginViewModel
import com.srisuk.carwashcustomer.viewmodel.PackageViewModel
import com.srisuk.carwashcustomer.viewmodel.ProfileViewModel
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
            .baseUrl("https://dev.chococrm.com:10004/")
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
}