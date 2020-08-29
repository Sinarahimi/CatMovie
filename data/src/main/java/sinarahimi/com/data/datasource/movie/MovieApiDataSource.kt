package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.api.MovieApi
import retrofit2.Response

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
interface MovieApiDataSource {

    suspend fun getTrends(
        media_type: String,
        time_window: String
    ):Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.Trend>>

    suspend fun getNowPlaying(
        language: String,
        page: Int
    ):Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.NowPlaying>>
}