package ru.techcrat.rxjavatest.networkModels

import ru.techcrat.rxjavatest.models.Film

data class FilmModel(
    val description: String,
    val director: String,
    val id: String,
    val image: String,
    val movie_banner: String,
    val original_title: String,
    val original_title_romanised: String,
    val producer: String,
    val release_date: String,
    val rt_score: String,
    val running_time: String,
    val title: String,
    val url: String,
)

