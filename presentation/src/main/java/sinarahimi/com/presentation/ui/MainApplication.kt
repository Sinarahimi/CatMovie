package sinarahimi.com.presentation.ui

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sinarahimi.com.presentation.ui.di.repositoryModule
import sinarahimi.com.presentation.ui.di.viewModelModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(provideDependency())
        }
    }

    private fun provideDependency() = appComponent

    private val appComponent = listOf(
        repositoryModule,
        viewModelModule
    )
}