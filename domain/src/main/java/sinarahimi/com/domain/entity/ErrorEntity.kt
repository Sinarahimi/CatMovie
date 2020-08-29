package sinarahimi.com.domain.entity

/**
 * Created by Sina Rahimi on 8/29/2020.
 */
sealed class ErrorEntity {

    object Network : ErrorEntity()

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    object Unknown : ErrorEntity()
}