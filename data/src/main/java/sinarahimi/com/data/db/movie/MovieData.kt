package com.sinarahimi.data.db.trend

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//
// Created by Sina Rahimi on 2/24/20.
//

sealed class MovieData {

    @Entity(tableName = "trend_table")
    data class Movie(
        @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) val id: Long,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "video") val video: Boolean,
        @ColumnInfo(name = "vote_count") val vote_count: Long,
        @ColumnInfo(name = "vote_average") val vote_average: Long,
        @ColumnInfo(name = "backdrop_path") val backdrop_path: String,
        @ColumnInfo(name = "poster_path") val poster_path: String,
        @ColumnInfo(name = "overview") val overview: String
    ) : MovieData()

    @Entity(tableName = "now_playing_table")
    data class NowPlaying(
        @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) val id: Long,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "poster_path") val poster_path: String
    ) : MovieData()

    @Entity(tableName = "category_table")
    data class Category(
        @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) val id: Long,
        @ColumnInfo(name = "name") val name: String
    ) : MovieData()


}