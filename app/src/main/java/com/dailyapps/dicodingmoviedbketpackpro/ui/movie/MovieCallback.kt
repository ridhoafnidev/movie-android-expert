package com.dailyapps.dicodingmoviedbketpackpro.ui.movie

import com.dailyapps.dicodingmoviedbketpackpro.data.Movie

interface MovieCallback {
    fun onShareLink(movie: Movie)
}