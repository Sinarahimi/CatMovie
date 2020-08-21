package sinarahimi.com.data.mapper

import com.sinarahimi.data.api.MovieApi
import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/20/2020.
 */

fun MovieApi.Dto.Trend.map() = CatMovieEntity.Trend(
    id = id,
    title = title,
    video = false,
    vote_count = 0,
    vote_average = 0,
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    overview = overview
)

fun MovieApi.Dto.NowPlaying.map() = CatMovieEntity.NowPlaying(
    id = id,
    title = title,
    poster_path = poster_path
)