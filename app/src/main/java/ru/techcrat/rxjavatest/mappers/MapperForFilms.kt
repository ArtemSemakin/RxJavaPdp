package ru.techcrat.rxjavatest.mappers

import ru.techcrat.rxjavatest.models.Film
import ru.techcrat.rxjavatest.networkModels.FilmModel

class MapperForFilms() : (FilmModel) -> Film {

    override fun invoke(model: FilmModel): Film = Film(
        id = model.id,
        title = model.original_title_romanised,
        description = model.description,
        image = model.image
    )
}
