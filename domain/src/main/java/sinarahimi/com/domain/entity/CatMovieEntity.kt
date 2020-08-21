package sinarahimi.com.domain.entity

/**
 * Created by Sina Rahimi on 8/21/2020.
 */

sealed class CatMovieEntity {

    data class Movie(
        val id: Long,
        val title: String,
        val video: Boolean,
        val vote_count: Long,
        val vote_average: Long,
        val backdrop_path: String,
        val poster_path: String,
        val overview: String
    )

    data class NowPlaying(
        val id: Long,
        val title: String,
        val poster_path: String
    )

    data class Category(
        val id: Long,
        val name: String
    )
}