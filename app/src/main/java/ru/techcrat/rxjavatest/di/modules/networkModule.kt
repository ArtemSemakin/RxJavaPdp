package ru.techcrat.rxjavatest.di.modules

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.techcrat.rxjavatest.BuildConfig
import ru.techcrat.rxjavatest.GhibliApiService

val networkModule = module {

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.API_BASE_URL)
            .build()
            .create(GhibliApiService::class.java)
    }
}
