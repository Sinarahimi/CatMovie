package com.sinarahimi.data.db.trend

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

//
// Created by Sina Rahimi on 2/24/20.
//

@Dao
interface MovieDao {

    /*Trend Movie*/
    /**
     * Obtain all database added trend movie .
     *
     * @return [LiveData] List with favorite characters.
     */
    @Query("SELECT * FROM trend_table ")
    fun getTrendList(): LiveData<List<MovieData.Trend>>

    //TODO here
//    @Query("SELECT * FROM trend_table WHERE id =:id ")
//    fun getTrendingById(id: Long): LiveData<>


    /*Now Playing Movie*/


    /*Category Movie*/
    /**
     * Obtain all database added trend movie .
     *
     * @return [LiveData] List with favorite characters.
     */
    @Query("SELECT * FROM category_table ")
    suspend fun getCategoryList(): List<MovieData.Category>


}