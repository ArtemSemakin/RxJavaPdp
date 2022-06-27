package ru.techcrat.rxjavatest.usecases

import ru.techcrat.rxjavatest.data.FilmsRepository
import ru.techcrat.rxjavatest.networkModels.toFilm

class ListOfFilmsUseCase (private val repository: FilmsRepository) {

    operator fun invoke() = repository.films().map { it.map { it.toFilm() } }

}
