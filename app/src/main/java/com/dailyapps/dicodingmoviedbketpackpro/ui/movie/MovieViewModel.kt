package com.dailyapps.dicodingmoviedbketpackpro.ui.movie

import androidx.lifecycle.ViewModel
import com.dailyapps.dicodingmoviedbketpackpro.data.Movie
import com.dailyapps.dicodingmoviedbketpackpro.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovie():ArrayList<Movie> = DataDummy.generateDummyMovie()
}