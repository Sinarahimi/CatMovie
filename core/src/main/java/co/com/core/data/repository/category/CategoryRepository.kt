package co.com.core.data.repository.category

import co.com.core.data.datasource.category.CategoryDataSource

class CategoryRepository(private val categoryDataSource: CategoryDataSource) {

    suspend fun getCategory() = categoryDataSource.getCategories()
}