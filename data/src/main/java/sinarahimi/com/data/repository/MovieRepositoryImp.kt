package sinarahimi.com.data.repository

import sinarahimi.com.data.datasource.movie.MovieApiDataSourceImp
import sinarahimi.com.data.datasource.movie.MovieDataBaseDataSourceImp
import sinarahimi.com.data.mapper.map
import sinarahimi.com.domain.entity.CatMovieEntity

/**
 * Created by Sina Rahimi on 8/21/2020.
 */
class MovieRepositoryImp(
    private val movieDbSource: MovieDataBaseDataSourceImp,
    private val movieApiSource: MovieApiDataSourceImp
) : MovieRepository {

    override suspend fun getAllTrend(
        media_type: String,
        time_window: String
    ): List<CatMovieEntity.Trend> {

        val result = try {

            if (movieDbSource.isTrendSEmpty()) {

                val response = movieApiSource.getTrends(media_type, time_window)

                if (response.isSuccessful) {

                    val trendList = response.body()?.results?.map { it.map() }
                    movieDbSource.insertAllTrends(trendList)
                } else {

                }
            } else {

                return movieDbSource.getAllTrends()
            }

        } catch (cause: Throwable) {

        }

    }


}