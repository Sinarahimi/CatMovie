package com.sinarahimi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sinarahimi.data.db.trend.MovieData
import sinarahimi.com.data.db.movie.MovieDao

//
// Created by Sina Rahimi on 2/24/20.
//

@Database(entities = [MovieData.Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}