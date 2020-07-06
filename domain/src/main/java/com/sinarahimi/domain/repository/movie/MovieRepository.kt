package com.sinarahimi.domain.repository.movie

import com.sinarahimi.domain.entity.Entity

interface MovieRepository {

    fun getTrendingMovies() : List<Entity.Trend>

    fun getCategories()

    fun getNowPlayingMovies()
}