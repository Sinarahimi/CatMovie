package com.sinarahimi.data.db.trend

import androidx.room.Dao
import androidx.room.Query
import com.sinarahimi.domain.entity.Entity

//
// Created by Sina Rahimi on 2/24/20.
//

@Dao
interface MovieDao{

    @Query("SELECT * FROM trend_table ")
    fun getTrendList():List<Entity.Trend>


}