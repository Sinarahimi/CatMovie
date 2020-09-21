package sinarahimi.com.presentation.ui.trend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sinarahimi.com.presentation.R

class TrendFragment : Fragment() {

    companion object {
        fun newInstance() = TrendFragment()
    }

    private lateinit var viewModel: TrendViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.trend_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrendViewModel::class.java)
        // TODO: Use the ViewModel
    }

}