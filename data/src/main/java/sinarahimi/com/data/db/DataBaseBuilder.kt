package sinarahimi.com.data.db

import android.content.Context
import androidx.room.Room
import com.sinarahimi.data.db.AppDatabase

/**
 * Created by Sina Rahimi on 8/12/2020.
 */
object DataBaseBuilder {

    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "database"
        ).build()
}