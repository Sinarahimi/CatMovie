package co.com.core.data.repository.trend

import co.com.core.data.datasource.trend.TrendDataSource

class TrendRepository(private val trendDataSource: TrendDataSource) {

    suspend fun getTrends() = trendDataSource.getTrends()
//TODO add debug
// boolean isDebug = ((getContext().getApplicationInfo().flags &
//    ApplicationInfo.FLAG_DEBUGGABLE) != 0);

}