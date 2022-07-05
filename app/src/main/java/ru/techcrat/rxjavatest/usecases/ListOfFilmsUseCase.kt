package ru.techcrat.rxjavatest.usecases

import io.reactivex.Observable
import ru.techcrat.rxjavatest.data.FilmsRepository
import ru.techcrat.rxjavatest.mappers.MapperForFilms
import ru.techcrat.rxjavatest.models.Film

class ListOfFilmsUseCase(
    private val repository: FilmsRepository,
    private val mapper: MapperForFilms
) {

    operator fun invoke(): Observable<List<Film>> = repository.films().map { it.map(mapper) }

}
