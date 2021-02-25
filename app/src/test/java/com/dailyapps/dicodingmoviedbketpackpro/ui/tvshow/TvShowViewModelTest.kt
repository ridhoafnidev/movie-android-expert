package com.dailyapps.dicodingmoviedbketpackpro.ui.tvshow

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun testGetTvShow() {
        val tvEntities = viewModel.getTvShow()
        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(10, tvEntities.size)
    }
}