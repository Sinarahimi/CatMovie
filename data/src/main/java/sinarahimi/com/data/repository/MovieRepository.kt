package sinarahimi.com.data.repository

import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/21/2020.
 */
interface MovieRepository {


    suspend fun getAllTrend( media_type: String,
                             time_window: String):ArrayList<CatMovieEntity.Trend>
}