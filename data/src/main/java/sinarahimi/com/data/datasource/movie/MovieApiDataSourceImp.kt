package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.api.MovieApi
import retrofit2.Response

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
class MovieApiDataSourceImp(private val api: MovieApi) : MovieApiDataSource {


    override suspend fun getTrends(
        media_type: String,
        time_window: String
    ): Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.Trend>> =

        api.getTrendingByMediaTypeAndTimeWindow(media_type, time_window)

    override suspend fun getNowPlaying(
        language: String,
        page: Int
    ): Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.NowPlaying>> =

        api.getNowPlaying(language, page)

}
