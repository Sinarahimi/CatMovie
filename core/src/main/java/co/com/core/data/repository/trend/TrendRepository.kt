package co.com.core.data.repository.trend

import co.com.core.data.datasource.trend.TrendDataSource

class TrendRepository(private val trendDataSource: TrendDataSource) {

    suspend fun getTrends() = trendDataSource.getTrends()


}