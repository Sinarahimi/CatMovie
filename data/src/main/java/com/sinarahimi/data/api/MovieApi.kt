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

    /**
     * Now Playing
     */
    //api_key
//language = en-US
//page = 1


    /**
     * Category
     */

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

    //GET
    ///movie/upcoming

//    /genre/movie/list


    ///movie/now_playing
    //{
    //  "page": 1,
    //  "results": [
    //    {
    // {
    //      "poster_path": "/1SWIUZp4Gi2B6VxajpPWKhkbTMF.jpg",
    //      "adult": false,
    //      "overview": "The legendary Roberto Duran and his equally legendary trainer Ray Arcel change each other's lives.",
    //      "release_date": "2016-08-26",
    //      "genre_ids": [
    //        18
    //      ],
    //      "id": 184341,
    //      "original_title": "Hands of Stone",
    //      "original_language": "en",
    //      "title": "Hands of Stone",
    //      "backdrop_path": "/pqRJD5RE5DgRQ1Mq4kSZHmMjozn.jpg",
    //      "popularity": 3.474028,
    //      "vote_count": 16,
    //      "video": false,
    //      "vote_average": 3.75
    //    }
    //  ],
    //  "dates": {
    //    "maximum": "2016-09-01",
    //    "minimum": "2016-07-21"
    //  },
    //  "total_pages": 33,
    //  "total_results": 649
    //}
}