package sinarahimi.com.data.mapper

import com.sinarahimi.data.db.trend.MovieData
import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/20/2020.
 */

fun CatMovieEntity.Movie.map() =  MovieData.Movie(
    id = id,
    title = title,
    video = video,
    vote_count = vote_count,
    vote_average = vote_average,
    backdrop_path = backdrop_path,
    poster_path = poster_path,
    overview = overview
)