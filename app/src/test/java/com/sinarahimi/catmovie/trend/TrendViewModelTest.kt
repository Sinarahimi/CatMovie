package com.sinarahimi.catmovie.trend

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sinarahimi.catmovie.di.*
import com.sinarahimi.catmovie.getOrAwaitValue
import io.mockk.MockKAnnotations
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.robolectric.annotation.Config
import sinarahimi.com.domain.usecase.movie.MovieUseCase

/**
 * Created by Sina Rahimi on 10/4/2020.
 */
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class TrendViewModelTest : KoinTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


     val movieUseCase: MovieUseCase by inject()

    @Before
    fun setUp() {

        MockKAnnotations.init(this)
        //Start Koin with required dependencies
        startKoin {modules(
            useCasesModule,
            viewModelModule,
            repositoryModule,
            databaseModule,
            networkModule,
        ) }
    }
//@Test
//fun test_login_view_model_data_populates_expected_value(){
//
//    mLoginActivityViewModel = LoginActivityViewModel
//                  (mDispatcher,mDispatcher,mLoginUseCase)

//    val sampleResponse = getJson("success_resp_list.json")
//    var jsonObj = Gson().fromJson(sampleResponse,
//                  AllPeople::class.java)
//    //Make sure login use case returns expected response when called
//    coEvery { mLoginUseCase.processLoginUseCase(any()) }
//             returns jsonObj
//    mLoginActivityViewModel.mAllPeopleResponse.observeForever {}
//
//    mLoginActivityViewModel.requestLoginActivityData(mParam)
//
//    assert(mLoginActivityViewModel.mAllPeopleResponse.value != null)
//    assert(mLoginActivityViewModel.mAllPeopleResponse.value!!.
//             responseStatus == LiveDataWrapper.
//                             RESPONSESTATUS.SUCCESS)
//    val testResult = mLoginActivityViewModel.mAllPeopleResponse
//          .value as LiveDataWrapper<AllPeople>
//    assertEquals(testResult.response!!.next,mNextValue)
//}

    val mediaType = "movie"
    val timeWindow = "week"

    @ExperimentalCoroutinesApi
    @Test
    fun `make a test`() =runBlockingTest {

        // Given a fresh TrendViewModel
        val trendViewModel = TrendViewModel(movieUseCase)

        // When getting trend list
        trendViewModel.getAllTrends(mediaType, timeWindow)

        // Then the trend list event is triggered
        val value = trendViewModel.trendsLiveData.getOrAwaitValue()

        assertThat(value, not(nullValue()))
    }

    @Test
    fun getErrorState() {
    }

    @Test
    fun setErrorState() {
    }

    @Test
    fun getAllTrends() {
    }
}