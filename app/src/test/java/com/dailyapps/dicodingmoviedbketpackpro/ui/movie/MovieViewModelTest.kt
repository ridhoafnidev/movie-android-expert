package com.dailyapps.dicodingmoviedbketpackpro.ui.movie

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun testGetMovie() {
        val movieEntities = viewModel.getMovie()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(12, movieEntities.size)
    }
}