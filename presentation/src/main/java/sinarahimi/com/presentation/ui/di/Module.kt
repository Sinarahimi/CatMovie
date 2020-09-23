package sinarahimi.com.presentation.ui.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sinarahimi.com.domain.usecase.movie.MovieUseCaseImp
import sinarahimi.com.presentation.ui.trend.TrendViewModel

/**
 * Created by Sina Rahimi on 9/21/2020.
 */

    val repositoryModule = module {

    single { MovieUseCaseImp(get()) }
}

    val viewModelModule = module {

        viewModel { TrendViewModel(get()) }
    }
