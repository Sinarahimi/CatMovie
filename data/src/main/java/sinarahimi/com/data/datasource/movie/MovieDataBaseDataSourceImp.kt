package sinarahimi.com.data.datasource.movie

import android.content.Context
import com.sinarahimi.data.db.trend.MovieData
import sinarahimi.com.data.db.DataBaseBuilder

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
class MovieDataBaseDataSourceImp(context: Context) : MovieDataBaseDataSource {

    private val appDataBase = DataBaseBuilder.getInstance(context)
    private val movieDao = appDataBase.movieDao()

    override suspend fun getAllTrends(): List<MovieData.Trend> {
        return movieDao.getAllTrends()
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