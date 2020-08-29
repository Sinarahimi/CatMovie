package sinarahimi.com.data.mapper

import com.sinarahimi.data.db.trend.MovieData
import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/20/2020.
 */

fun CatMovieEntity.Trend.map() = MovieData.Trend(
    id = id,
    title = title,
    video = video,
    vote_count = vote_count,
    vote_average = vote_average,
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    overview = overview
)

fun CatMovieEntity.NowPlaying.map() = MovieData.NowPlaying(
    id = id,
    title = title,
    poster_path = poster_path
)

fun CatMovieEntity.Category.map() = MovieData.Category(
    id = id,
    name = name
)