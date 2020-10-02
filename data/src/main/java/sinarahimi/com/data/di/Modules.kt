package sinarahimi.com.data.di

import android.app.Application
import androidx.room.Room
import com.sinarahimi.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import sinarahimi.com.data.datasource.movie.MovieApiDataSourceImp
import sinarahimi.com.data.datasource.movie.MovieDataBaseDataSource
import sinarahimi.com.data.datasource.movie.MovieDataBaseDataSourceImp
import sinarahimi.com.data.db.movie.MovieDao
import sinarahimi.com.data.repository.MovieRepository
import sinarahimi.com.data.repository.MovieRepositoryImp

/**
 * Created by Sina Rahimi on 10/2/2020.
 */

val repositoryModule = module {

    fun provideMovieRepositoryImp(
        movieDbSource: MovieDataBaseDataSourceImp,
        movieApiSource: MovieApiDataSourceImp
    ): MovieRepository {
        return MovieRepositoryImp(movieDbSource, movieApiSource)
    }

    fun provideMovieDataBaseDataSourceImp(movieDao: MovieDao): MovieDataBaseDataSource {
        return MovieDataBaseDataSourceImp(movieDao)
    }

    single { provideMovieRepositoryImp(get(), get()) }

    single {provideMovieDataBaseDataSourceImp(get())}
}

val databaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application, AppDatabase::class.java,
            "database"
        ).build()
    }


    fun provideMovieDao(database: AppDatabase): MovieDao {
        return database.movieDao()
    }

    single { provideDatabase(androidApplication()) }

    single { provideMovieDao(get()) }
}

//provide { MyDatabase.buildDatabase(androidApplication()) }
//provide { get<MyDatabase>().getDao1() }
//provide { get<MyDatabase>().getDao2() }