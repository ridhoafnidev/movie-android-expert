package com.dailyapps.dicodingmoviedbketpackpro.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataTv(
    val page: Int?,
    val results: List<Tv>?,
    val total_pages: Int?,
    val total_results: Int?
) : Parcelable

@Parcelize
data class Tv(
    val backdrop_path: String?,
    val first_air_date: String?,
    val id: Int?,
    val name: String?,
    val original_name: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Double
) : Parcelable

@Parcelize
data class DataMovie(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
) : Parcelable

@Parcelize
data class Movie(
    val backdrop_path: String,
    val id: Int?,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double
) : Parcelable