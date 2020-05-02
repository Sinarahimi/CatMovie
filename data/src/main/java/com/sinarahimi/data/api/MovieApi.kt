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
     */
    @GET("/trending/{media_type}/{time_window}")
    suspend fun getTrendingByMediaTypeAndTimeWindow(
        @Path("media_type") media_type: String,
        @Path("time_window") time_window: String
    ): Response<Response<Dto.Trend>>
    //


    /**
     * Now Playing
     */
    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String, @Query("language") language: String,
        @Query("page") page: Int
    ): Response<Dto.ResponseRequest<Dto.NowPlaying>>
    //api_key
//language = en-US
//page = 1


    /**
     * Categories
     */
    @GET("/genre/movie/list")
    suspend fun getCategories(@Query("api_key") apiKey: String): Response<Dto.ResponseRequestGenre>

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

        data class ResponseRequest<T>(
            @SerializedName("page") val page: Long,
            @SerializedName("total_pages") val total_pages: Long,
            @SerializedName("total_results") val total_results: Long,
            @SerializedName("results") val results: ArrayList<T>
        )

        data class ResponseRequestGenre(
            @SerializedName("genres") val results: ArrayList<Category>
        )
    }
}