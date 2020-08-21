package sinarahimi.com.data.repository

/**
 * Created by Sina Rahimi on 8/21/2020.
 */
interface MovieRepository {


    suspend fun getAllTrend( media_type: String,
                             time_window: String)
}