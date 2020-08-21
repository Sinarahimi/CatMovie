package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.api.MovieApi
import kotlinx.coroutines.Deferred
import retrofit2.Response

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
interface MovieApiDataSource {

    suspend fun getTrendingByMediaTypeAndTimeWindow(
        media_type: String,
        time_window: String
    ):Deferred<Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.Trend>>>

    suspend fun getNowPlaying(
        language: String,
        page: Int
    ):Deferred<Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.NowPlaying>>>
}