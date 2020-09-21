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

        try {

            //TODO fix the null part
            if (movieDbSource.isTrendsEmpty()) {

                val response = movieApiSource.getTrends(media_type, time_window)

                if (response.isSuccessful) {

                    val result = response.body()?.results
                    if (result != null) {

                        val mappedList = result.map { it.map() }
                        movieDbSource.insertAllTrends(mappedList)
                    }

                } else {
                    //TODO here
                }

                return movieDbSource.getAllTrends()
            } else {

                return movieDbSource.getAllTrends()
            }

        } catch (cause: Throwable) {

            throw cause
        }
    }


}