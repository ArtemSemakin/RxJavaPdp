package ru.techcrat.rxjavatest

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.techcrat.rxjavatest.di.modules.networkModule
import ru.techcrat.rxjavatest.di.modules.repositoryModule
import ru.techcrat.rxjavatest.di.modules.usecaseModule
import ru.techcrat.rxjavatest.di.modules.viewModelModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            modules(
                networkModule,
                viewModelModule,
                repositoryModule,
                usecaseModule
            )
        }
    }
}
