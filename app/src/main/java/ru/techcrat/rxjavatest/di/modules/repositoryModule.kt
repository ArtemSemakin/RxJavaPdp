package ru.techcrat.rxjavatest.di.modules

import org.koin.dsl.module
import ru.techcrat.rxjavatest.data.FilmsRepository
import ru.techcrat.rxjavatest.data.impl.FilmsRepositoryImpl

val repositoryModule = module {

    factory<FilmsRepository> {
        FilmsRepositoryImpl(get())
    }
}
