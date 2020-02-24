package com.sinarahimi.data.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path

//
// Created by Sina Rahimi on 2/23/20.
//

interface MovieApi {


    /**
     * Trending
     */

    @GET("/trending/{media_type}/{time_window}")
    fun getTrendingByMediaTypeAndTimeWindow(@Path("media_type") media_type: String, @Path("time_window") time_window: String)


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
    }
}