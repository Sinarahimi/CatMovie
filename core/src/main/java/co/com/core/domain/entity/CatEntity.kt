package com.sinarahimi.domain.entity

//
// Created by Sina Rahimi on 2/23/20.
// Copyright (c) 2020 sinarahimi.com. All rights reserved.
//
/*
* Because there is a class named Entity is Android SDk i decided to make it unique by adding cat
* */
sealed class CatEntity {

    data class Genres(
        val id: Long,
        val name: String
    ):CatEntity()

    data class Trend(
        val id: Long,
        val title: String,
        val video: Boolean,
        val vote_count: Long,
        val vote_average: Long,
        val backdrop_path: String,
        val release_date: String,
        val poster_path: String,
        val overview: String

    ):CatEntity()

}