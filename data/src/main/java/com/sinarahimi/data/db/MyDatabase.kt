package com.sinarahimi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sinarahimi.data.db.trend.MovieDao
import com.sinarahimi.data.db.trend.MovieData

//
// Created by Sina Rahimi on 2/24/20.
//

@Database(entities = [MovieData.Trade::class,MovieData.NowPlaying::class,
    MovieData.Category::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun TrendDao(): MovieDao
}