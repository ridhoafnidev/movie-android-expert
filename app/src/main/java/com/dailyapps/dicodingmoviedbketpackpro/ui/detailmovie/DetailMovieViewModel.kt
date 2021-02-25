package com.dailyapps.dicodingmoviedbketpackpro.ui.detailmovie

import androidx.lifecycle.ViewModel
import com.dailyapps.dicodingmoviedbketpackpro.data.Movie
import com.dailyapps.dicodingmoviedbketpackpro.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private var id: Int? = 0

    fun setSelectedMovie(id: Int?) {
        this.id = id
    }

    fun getMovie(): Movie {
        lateinit var movie: Movie
        val movieEntities = DataDummy.generateDummyMovie()
        for (movieEntity in movieEntities)
            if (movieEntity.id == id){
                movie = movieEntity
            }
        return movie
    }
}