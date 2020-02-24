package com.sinarahimi.domain.entity

//
// Created by Sina Rahimi on 2/23/20.
// Copyright (c) 2020 sinarahimi.com. All rights reserved.
//

sealed class Entity {

    data class Genres(
        val id: Long,
        val name: String
    ):Entity()

    data class Trend(
        val id: Long,
        val title: String,
        val video: Boolean,
        val vote_count: Long,
        val vote_average: Long,
        val backdrop_path: String,
        val poster_path: String,
        val overview: String

    ):Entity()

}