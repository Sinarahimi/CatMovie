package co.com.core.domain.usecase.category

import co.com.core.data.repository.category.CategoryRepository

class GetAlbumUseCase(private val categoryRepository: CategoryRepository) {

    suspend operator fun invoke() = categoryRepository.getCategory()
}