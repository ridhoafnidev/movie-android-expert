package com.dailyapps.dicodingmoviedbketpackpro.ui.detailmovie

import com.dailyapps.dicodingmoviedbketpackpro.utils.DataDummy
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val id = dummyMovie.id

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(id)
    }

    @Test
    fun testGetMovie() {
        viewModel.setSelectedMovie(dummyMovie.id)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.release_date, movieEntity.release_date)
        assertEquals(dummyMovie.backdrop_path, movieEntity.backdrop_path)
        assertEquals(dummyMovie.original_title, movieEntity.original_title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.poster_path, movieEntity.poster_path)
        assertEquals(dummyMovie.vote_average.toString(), movieEntity.vote_average.toString())
    }
}