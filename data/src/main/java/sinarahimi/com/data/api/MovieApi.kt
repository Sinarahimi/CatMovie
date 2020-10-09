package com.sinarahimi.data.api

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//
// Created by Sina Rahimi on 2/23/20.
//

interface MovieApi {

    /**
     * Trending
     * @media_type = movie
     * @time_window = week
     */
    @GET("/trending/{media_type}/{time_window}")
    suspend fun getTrendingByMediaTypeAndTimeWindow(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String
    ): Response<Dto.BaseResponse<Dto.Trend>>


    /**
     * Now Playing
     * language = en-US
     * page = 1
     */
    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<Dto.BaseResponse<Dto.NowPlaying>>

    sealed class Dto {

        data class Trend(
            @SerializedName("id") val id: Long,
            @SerializedName("title") val title: String,
            @SerializedName("vote_count") val voteCount: Long,
            @SerializedName("vote_average") val voteAverage: Long,
            @SerializedName("backdrop_path") val backdrop_path: String,
            @SerializedName("poster_path") val poster_path: String,
            @SerializedName("overview") val overview: String
        )

        data class NowPlaying(
            @SerializedName("id") val id: Long,
            @SerializedName("title") val title: String,
            @SerializedName("poster_path") val poster_path: String
        )

        data class Category(
            @SerializedName("id") val id: Long,
            @SerializedName("name") val name: String
        )

        data class BaseResponse<T>(
            @SerializedName("page") val page: Long,
            @SerializedName("total_pages") val total_pages: Long,
            @SerializedName("total_results") val total_results: Long,
            @SerializedName("results") val results: List<T>
        )

        data class ResponseRequestGenre(
            @SerializedName("genres") val results: ArrayList<Category>
        )
    }
}