package com.sinarahimi.catmovie

import android.app.Application
import com.sinarahimi.catmovie.di.databaseModule
import com.sinarahimi.catmovie.di.networkModule
import com.sinarahimi.catmovie.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Sina Rahimi on 10/2/2020.
 */

class CatMovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CatMovieApplication)
            modules(
                repositoryModule,
                databaseModule,
                networkModule,
            )
        }
    }
}