package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.api.MovieApi
import retrofit2.Response

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
interface MovieApiDataSource {

    suspend fun getTrendingByMediaTypeAndTimeWindow(
        media_type: String,
        time_window: String
    ): Response<ArrayList<MovieApi.Dto.Trend>>

    suspend fun getNowPlaying(
        language: String,
        page: Int
    ):Response<MovieApi.Dto.ResponseRequest<MovieApi.Dto.NowPlaying>>
}