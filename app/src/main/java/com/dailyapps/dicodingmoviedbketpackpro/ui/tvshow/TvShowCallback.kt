package com.dailyapps.dicodingmoviedbketpackpro.ui.tvshow

import com.dailyapps.dicodingmoviedbketpackpro.data.Tv

interface TvShowCallback {
    fun onShareLink(tv: Tv)
}