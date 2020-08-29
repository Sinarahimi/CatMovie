package sinarahimi.com.data.datasource.movie

import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
interface MovieDataBaseDataSource {

    suspend fun getAllTrends(): List<CatMovieEntity.Trend>

    suspend fun getTrendSize(): Int

    suspend fun isTrendSEmpty(): Boolean

    suspend fun insertAllTrends(trendList: List<CatMovieEntity.Trend>)

    suspend fun getAllCategories(): List<CatMovieEntity.Category>

    suspend fun insertAllCategories(categories: List<CatMovieEntity.Category>)
}