package com.sinarahimi.catmovie.trend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sinarahimi.catmovie.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import sinarahimi.com.domain.entity.CatMovieEntity
import sinarahimi.com.presentation.ui.extension.observe

class TrendFragment : Fragment() {

    private val viewModel: TrendViewModel by viewModel()

    companion object {
        fun newInstance() = TrendFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.trend_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.trendsLiveData, ::showTrends)
        observe(viewModel.errorState,::showError)
    }

    private fun showError(throwable: Throwable?) {

    }

    private fun showTrends(trends: List<CatMovieEntity.Trend>) {

    }
}