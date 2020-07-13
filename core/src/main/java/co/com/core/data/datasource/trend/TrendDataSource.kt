package co.com.core.data.datasource.trend

import com.sinarahimi.domain.entity.CatEntity

interface TrendDataSource {

    suspend fun getTrends() : List<CatEntity.Trend>
}
