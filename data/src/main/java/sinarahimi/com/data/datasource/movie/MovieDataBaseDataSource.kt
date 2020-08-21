package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.db.trend.MovieData

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
interface MovieDataBaseDataSource {

    suspend fun getAllTrends(): List<MovieData.Trend>

    suspend fun insertAllTrends(trendList: List<MovieData.Trend>)

    suspend fun getAllCategories(): List<MovieData.Category>

    suspend fun insertAllCategories(categories: List<MovieData.Category>)
}