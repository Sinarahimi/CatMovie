package sinarahimi.com.domain.usecase.movie

import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/30/2020.
 */
interface MovieUseCase {

    fun getAllTrend(mediaType: String,
                    timeWindow: String
    ): List<CatMovieEntity.Trend>


}