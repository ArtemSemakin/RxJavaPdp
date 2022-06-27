package ru.techcrat.rxjavatest.data.impl

import io.reactivex.Observable
import ru.techcrat.rxjavatest.GhibliApiService
import ru.techcrat.rxjavatest.data.FilmsRepository
import ru.techcrat.rxjavatest.networkModels.FilmModel

class FilmsRepositoryImpl(private val apiService: GhibliApiService) : FilmsRepository {

    override fun films(): Observable<List<FilmModel>> = apiService.getGhibliFilms()

}
