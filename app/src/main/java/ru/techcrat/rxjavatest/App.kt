package ru.techcrat.rxjavatest

import android.app.Application
import org.koin.core.context.startKoin
import ru.techcrat.rxjavatest.di.modules.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            modules(
                networkModule,
                viewModelModule,
                repositoryModule,
                usecaseModule,
                mappersModule
            )
        }
    }
}
