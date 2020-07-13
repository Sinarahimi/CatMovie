package com.sinarahimi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sinarahimi.data.db.trend.TrendDao
import com.sinarahimi.data.db.trend.TrendData

//
// Created by Sina Rahimi on 2/24/20.
//

@Database(entities = [TrendData.Trend::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun trendDao(): TrendDao
}