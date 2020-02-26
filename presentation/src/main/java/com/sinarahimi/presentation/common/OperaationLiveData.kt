package com.sinarahimi.presentation.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

//
// Created by Sina Rahimi on 2/26/20.
//

class OperaationLiveData<T>(private val operaationLiveData: OperaationLiveData<T>.() -> Unit) :
    MutableLiveData<T>() {

    private var isOperated = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)

    }

    override fun observeForever(observer: Observer<in T>) {
        super.observeForever(observer)
    }

    private fun operate() {

        if (value != null && isOperated.get()) {
            return
        }

        operaationLiveData()
        isOperated.set(true)
    }
}