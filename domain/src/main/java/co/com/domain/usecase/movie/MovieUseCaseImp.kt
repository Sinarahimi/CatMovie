package co.com.domain.usecase.movie

import sinarahimi.com.domain.entity.CatMovieEntity
import sinarahimi.com.domain.usecase.movie.MovieUseCase

/**
 * Created by Sina Rahimi on 10/3/2020.
 */
class MovieUseCaseImp : MovieUseCase {
    override suspend fun getAllTrend(
        mediaType: String,
        timeWindow: String
    ): List<CatMovieEntity.Trend> {
        TODO("Not yet implemented")
    }

}