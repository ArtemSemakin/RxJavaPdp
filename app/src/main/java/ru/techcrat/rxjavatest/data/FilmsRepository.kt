package ru.techcrat.rxjavatest.data

import io.reactivex.Observable
import ru.techcrat.rxjavatest.networkModels.FilmModel

interface FilmsRepository {

     fun films(): Observable<List<FilmModel>>

}
