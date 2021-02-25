package com.dailyapps.dicodingmoviedbketpackpro.ui.detailtvshow

import androidx.lifecycle.ViewModel
import com.dailyapps.dicodingmoviedbketpackpro.data.Tv
import com.dailyapps.dicodingmoviedbketpackpro.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {
    private var id: Int? = 0

    fun setSelectedTv(id: Int?) {
        this.id = id
    }

    fun getTv(): Tv {
        lateinit var tv: Tv
        val tvEntities = DataDummy.generateDummyTvShow()
        for (tvEntity in tvEntities)
            if (tvEntity.id == id) {
                tv = tvEntity
            }
        return tv
    }
}