package com.sinarahimi.data.db.trend

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//
// Created by Sina Rahimi on 2/24/20.
//
/*Trend Movie*/
@Dao
interface TrendDao {


    /**
     * Obtain all database added trend movie .
     *
     * @return [LiveData] List with favorite characters.
     */
    @Query("SELECT * FROM trend_table ")
    fun selectAll(): LiveData<List<TrendData.Trend>>

    /*
    * Add Trend movie to database
    * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(TrendList: List<TrendData.Trend>)


    /*Category Movie*/
    /**
     * Obtain all database added trend movie .
     *
     * @return [LiveData] List with favorite characters.
     */
//    @Query("SELECT * FROM category_table ")
//    suspend fun getCategoryList(): List<TrendData.Category>


}