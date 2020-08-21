package sinarahimi.com.data.datasource.movie

import com.sinarahimi.data.api.MovieApi
import ir.lupinwedding.business.network.RetrofitHelper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Response
import sinarahimi.com.data.BuildConfig

/**
 * Created by Sina Rahimi on 8/20/2020.
 */
class MovieApiDataSourceImp : MovieApiDataSource {

    private val API_KEY = BuildConfig.API_KEY

    private val service = RetrofitHelper.retrofitService(MovieApi::class.java)

    override suspend fun getTrendingByMediaTypeAndTimeWindow(
        media_type: String,
        time_window: String
    ): Deferred<Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.Trend>>> =
        withContext(Dispatchers.IO) {
            async {
                service.getTrendingByMediaTypeAndTimeWindow(API_KEY, media_type, time_window)
            }
        }

    override suspend fun getNowPlaying(
        language: String,
        page: Int
    ): Deferred<Response<MovieApi.Dto.BaseResponse<MovieApi.Dto.NowPlaying>>> =
        withContext(Dispatchers.IO) {
            async {
                service.getNowPlaying(API_KEY, language, page)
            }
        }

}