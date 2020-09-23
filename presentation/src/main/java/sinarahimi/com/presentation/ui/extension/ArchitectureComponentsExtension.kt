package sinarahimi.com.presentation.ui.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Created by Sina Rahimi on 9/23/2020.
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun <T : Any?> MutableLiveData<T>.defaultValue(initialValue: T) = apply { setValue(initialValue) }