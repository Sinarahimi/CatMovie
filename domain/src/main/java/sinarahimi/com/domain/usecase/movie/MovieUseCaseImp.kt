package sinarahimi.com.domain.usecase.movie

import sinarahimi.com.domain.entity.CatMovieEntity
import sinarahimi.com.domain.repository.movie.MovieRepository

/**
 * Created by Sina Rahimi on 8/30/2020.
 */
class MovieUseCaseImp(private val movieRepository: MovieRepository) : MovieUseCase {

    override fun getAllTrend(mediaType: String, timeWindow: String): List<CatMovieEntity.Trend> {

        return movieRepository.getAllTrend(mediaType,timeWindow)
    }
}