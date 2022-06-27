package ru.techcrat.rxjavatest

import io.reactivex.Observable
import retrofit2.http.GET
import ru.techcrat.rxjavatest.networkModels.FilmModel

interface GhibliApiService {

    @GET("/films")
    fun getGhibliFilms(): Observable<List<FilmModel>>
}
