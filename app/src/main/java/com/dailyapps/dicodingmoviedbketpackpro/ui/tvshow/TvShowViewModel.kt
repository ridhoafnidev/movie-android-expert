package com.dailyapps.dicodingmoviedbketpackpro.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dailyapps.dicodingmoviedbketpackpro.data.Tv
import com.dailyapps.dicodingmoviedbketpackpro.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow():ArrayList<Tv> = DataDummy.generateDummyTvShow()
}