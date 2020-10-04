package com.sinarahimi.catmovie.di

import android.app.Application
import androidx.room.Room
import co.com.domain.usecase.movie.MovieUseCaseImp
import com.sinarahimi.catmovie.trend.TrendViewModel
import com.sinarahimi.data.api.MovieApi
import com.sinarahimi.data.db.AppDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sinarahimi.com.data.BuildConfig.BASE_URL
import sinarahimi.com.data.datasource.movie.MovieApiDataSource
import sinarahimi.com.data.datasource.movie.MovieApiDataSourceImp
import sinarahimi.com.data.datasource.movie.MovieDataBaseDataSource
import sinarahimi.com.data.datasource.movie.MovieDataBaseDataSourceImp
import sinarahimi.com.data.db.movie.MovieDao
import sinarahimi.com.data.repository.MovieRepository
import sinarahimi.com.data.repository.MovieRepositoryImp
import sinarahimi.com.domain.usecase.movie.MovieUseCase
import java.util.concurrent.TimeUnit

/**
 * Created by Sina Rahimi on 10/2/2020.
 */
private const val CONNECT_TIMEOUT = 60L
private const val WRITE_TIMEOUT = 60L
private const val READ_TIMEOUT = 60L

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

    fun provideMovieApiDataSourceImp(api: MovieApi): MovieApiDataSource {
        return MovieApiDataSourceImp(api)
    }

    single { provideMovieApiDataSourceImp(get()) }

    single { provideMovieRepositoryImp(get(), get()) }

    single { provideMovieDataBaseDataSourceImp(get()) }
}

val useCasesModule = module {


    single<MovieUseCase> { MovieUseCaseImp() }
}

val viewModelModule = module {

    viewModel { TrendViewModel(get()) }
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

val networkModule = module {

    single {

        OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(MovieApi::class.java) }
}