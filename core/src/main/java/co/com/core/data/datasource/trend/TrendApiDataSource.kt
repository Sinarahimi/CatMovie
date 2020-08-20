package co.com.core.data.datasource.trend

interface TrendApiDataSource{

    suspend fun getTrends(media_type: String,
                          time_window: String)
}