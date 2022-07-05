package ru.techcrat.rxjavatest.di.modules

import org.koin.dsl.module
import ru.techcrat.rxjavatest.mappers.MapperForFilms

val mappersModule = module {
    single { MapperForFilms() }
}
