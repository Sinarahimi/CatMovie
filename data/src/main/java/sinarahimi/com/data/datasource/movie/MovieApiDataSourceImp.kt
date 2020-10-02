package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.api.MovieApi
import retrofit2.Response
import sinarahimi.com.data.BuildConfig

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
class MovieApiDataSourceImp(private val api: MovieApi) : MovieApiDataSource {

    private val apiKey = BuildConfig.API_KEY

    override suspend fun getTrends(
        media_type: String,
        time_window: String
    ): Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.Trend>> =

        api.getTrendingByMediaTypeAndTimeWindow(apiKey, media_type, time_window)

    override suspend fun getNowPlaying(
        language: String,
        page: Int
    ): Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.NowPlaying>> =

        api.getNowPlaying(apiKey, language, page)

}
