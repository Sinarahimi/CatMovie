package sinarahimi.com.domain.entity

/**
 * Created by Sina Rahimi on 8/29/2020.
 */
interface ErrorHandlerCatMovie {

    fun getError(throwable: Throwable): ErrorEntity
}