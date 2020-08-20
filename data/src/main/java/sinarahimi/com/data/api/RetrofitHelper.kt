package ir.lupinwedding.business.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sinarahimi.com.data.BuildConfig
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private val BASE_URL = BuildConfig.BASE_URL

    //TODO add buildConfig.DEBUG to logging retrofit

    fun <T> retrofitService(api: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(makeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(api)
    }

    private fun makeOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(makeLoggingInterceptor())
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }


    class ErrorInterceptor() : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            val response = chain.proceed(request)
            when (response.code) {
                400 -> {
                    //Show Bad Request Error Message
                }
                401 -> {
                    val newToken: String = ""//fetch from some other source
                    if (newToken != null) {
                        val newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", newToken)
                            .build()
                        return chain.proceed(newRequest)
                    }
                }

                403 -> {
                    //Show Forbidden Message
                }

                404 -> {
                    //Show NotFound Message
                }

                // ... and so on

            }
            return response
        }

    }

    //TODO change the request
    fun request() {

    }

    fun <T> onResponse(c: Class<T>) {

    }

    interface ApiListener {

        fun onSuccess()

        fun onFailure()

        fun netWorkChacking()
    }

}