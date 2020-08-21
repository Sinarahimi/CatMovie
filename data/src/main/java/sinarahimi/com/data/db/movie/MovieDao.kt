package sinarahimi.com.data.db.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sinarahimi.data.db.trend.MovieData

/**
 * When the functions are marked suspend,
 * Room ensures they are main-safe.
 * That means you can call them directly from Dispatchers.Main
 * */

@Dao
interface MovieDao {

    /* Trend */
    /**
     * Obtain all database added trend movie .
     *
     * @return List with movies.
     */
    @Query("SELECT * FROM trend_table ")
    suspend fun getAllTrends(): List<MovieData.Trend>

    /*
    * Add Trend movie to database
    * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTrends(trendList: List<MovieData.Trend>)


    /*Category*/
    /**
     * Obtain all database added category .
     *
     * @return  List with categories.
     */
    @Query("SELECT * FROM category_table ")
    suspend fun getAllCategories(): List<MovieData.Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categories: List<MovieData.Category>)

}