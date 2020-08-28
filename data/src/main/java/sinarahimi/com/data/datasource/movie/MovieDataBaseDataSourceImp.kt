package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.db.trend.MovieData
import sinarahimi.com.data.db.movie.MovieDao

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
class MovieDataBaseDataSourceImp(private val movieDao: MovieDao) : MovieDataBaseDataSource {

    override suspend fun getAllTrends(): List<MovieData.Trend> {
        return movieDao.getAllTrends()
    }

    override suspend fun getTrendSize(): Int {
        return movieDao.getTrendSize()
    }

    override suspend fun insertAllTrends(trendList: List<MovieData.Trend>) {
        movieDao.insertAllTrends(trendList)
    }

    override suspend fun getAllCategories(): List<MovieData.Category> {
       return movieDao.getAllCategories()
    }

    override suspend fun insertAllCategories(categories: List<MovieData.Category>) {
        movieDao.insertAllCategories(categories)
    }
}