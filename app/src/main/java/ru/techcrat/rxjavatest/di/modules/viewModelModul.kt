package ru.techcrat.rxjavatest.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import ru.techcrat.rxjavatest.FirstViewModel
import ru.techcrat.rxjavatest.data.FilmsRepository
import ru.techcrat.rxjavatest.usecases.ListOfFilmsUseCase

val viewModelModule = module {

    viewModel {
        FirstViewModel(get(ListOfFilmsUseCase::class.java))
    }
}
