package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.api.MovieApi
import ir.lupinwedding.business.network.RetrofitHelper
import retrofit2.Response
import sinarahimi.com.data.BuildConfig

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
class MovieApiDataSourceImp : MovieApiDataSource   {

    private val API_KEY = BuildConfig.API_KEY

    private val service = RetrofitHelper.retrofitService(MovieApi::class.java)

    override suspend fun getTrendingByMediaTypeAndTimeWindow(
        media_type: String,
        time_window: String
    ): Response<ArrayList<MovieApi.Dto.Trend>> {

        return service.getTrendingByMediaTypeAndTimeWindow()
    }

    override suspend fun getNowPlaying(
        language: String,
        page: Int
    ): Response<MovieApi.Dto.ResponseRequest<MovieApi.Dto.NowPlaying>> {
        return service.getNowPlaying()
    }

}