package ru.techcrat.rxjavatest.di.modules

import org.koin.dsl.module
import ru.techcrat.rxjavatest.usecases.ListOfFilmsUseCase

val usecaseModule = module{
    single {
        ListOfFilmsUseCase(get())
    }
}
