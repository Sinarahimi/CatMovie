package sinarahimi.com.data.datasource.movie

import sinarahimi.com.data.db.movie.MovieDao
import sinarahimi.com.data.mapper.map
import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
class MovieDataBaseDataSourceImp(private val movieDao: MovieDao) : MovieDataBaseDataSource {

    override suspend fun getAllTrends(): List<CatMovieEntity.Trend> {
        return movieDao.getAllTrends().map { it.map() }
    }

    override suspend fun getTrendSize(): Int {
        return movieDao.getTrendSize()
    }

    override suspend fun isTrendSEmpty(): Boolean {
        return movieDao.getTrendSize() <= 0
    }

    override suspend fun insertAllTrends(trendList: List<CatMovieEntity.Trend>) {
        movieDao.insertAllTrends(trendList.map { it.map() })
    }

    override suspend fun getAllCategories(): List<CatMovieEntity.Category> {
       return movieDao.getAllCategories().map { it.map() }
    }

    override suspend fun insertAllCategories(categories: List<CatMovieEntity.Category>) {
        movieDao.insertAllCategories(categories.map { it.map() })
    }
}