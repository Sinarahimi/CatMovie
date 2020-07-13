package co.com.core.domain.usecase.trend

import co.com.core.data.repository.trend.TrendRepository

class GetTrendUseCase(private val trendRepository: TrendRepository) {

    suspend operator fun invoke() = trendRepository.getTrends()
}