package sinarahimi.com.data.utils

import retrofit2.HttpException
import sinarahimi.com.domain.entity.ErrorEntity
import sinarahimi.com.domain.entity.ErrorHandlerCatMovie
import java.io.IOException
import java.net.HttpURLConnection

/**
 * Created by Sina Rahimi on 8/29/2020.
 */
class GeneralErrorHandlerImpl() : ErrorHandlerCatMovie {

    override fun getError(throwable: Throwable): ErrorEntity {
        return when(throwable) {

            is IOException -> ErrorEntity.Network
            is HttpException -> {

                when(throwable.code()) {
                    // no cache found in case of no network, thrown by retrofit -> treated as network error
//                    DataConstants.Network.HttpStatusCode.UNSATISFIABLE_REQUEST -> ErrorEntity.Network

                    // not found
                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound

                    // access denied
                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied

                    // unavailable service
                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable

                    // all the others will be treated as unknown error
                    else -> ErrorEntity.Unknown
                }
            }

            else -> ErrorEntity.Unknown
        }
    }
}