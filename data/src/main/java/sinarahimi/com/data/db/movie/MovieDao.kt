package sinarahimi.com.data.db.movie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sinarahimi.data.db.trend.MovieData

@Dao
interface MovieDao{

    /**
     * Obtain all database added trend movie .
     *
     * @return [LiveData] List with favorite characters.
     */
    @Query("SELECT * FROM trend_table ")
    fun selectAll(): LiveData<List<MovieData.Movie>>

    /*
    * Add Trend movie to database
    * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieList: List<MovieData.Movie>)


    /*Category Movie*/
    /**
     * Obtain all database added trend movie .
     *
     * @return [LiveData] List with favorite characters.
     */
//    @Query("SELECT * FROM category_table ")
//    suspend fun getCategoryList(): List<TrendData.Category>
}