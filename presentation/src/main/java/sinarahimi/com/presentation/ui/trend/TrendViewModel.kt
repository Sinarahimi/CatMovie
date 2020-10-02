package sinarahimi.com.presentation.ui.trend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sinarahimi.com.domain.entity.CatMovieEntity
import sinarahimi.com.domain.usecase.movie.MovieUseCase
import sinarahimi.com.presentation.ui.common.SingleLiveEvent

class TrendViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _trendsLiveData = MutableLiveData<List<CatMovieEntity.Trend>>()

    val trendsLiveData:LiveData<List<CatMovieEntity.Trend>> get() = _trendsLiveData
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    fun getAllTrends(mediaType: String, timeWindow: String) = viewModelScope.launch {

            kotlin.runCatching {

                    movieUseCase.getAllTrend(mediaType,timeWindow)
            }.onFailure{throwable ->

                errorState.postValue(throwable)
            }.onSuccess {trendList ->

                _trendsLiveData.postValue(trendList)
            }
    }
}