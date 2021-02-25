package com.dailyapps.dicodingmoviedbketpackpro.utils.commons

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.dailyapps.dicodingmoviedbketpackpro.R

class Utils {

    fun imageTopRound(imageView: ImageView, url: String?, context: Context?, scaleType: ImageView.ScaleType? = null) {
        url?.let {
            val radius = context?.resources?.getDimensionPixelSize(R.dimen.radius)
            var requestOptions = RequestOptions()

            val roundTransform = radius?.let { it1 -> RoundedCornersTransformation(it1, 0, RoundedCornersTransformation.CornerType.TOP) }
            requestOptions = requestOptions.transform(CenterCrop(), roundTransform)
            requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            requestOptions = requestOptions.placeholder(R.drawable.ic_loading).error(R.drawable.ic_error)

            if(scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                requestOptions = requestOptions.centerInside()
            }

            context?.let { data ->
                Glide.with(data)
                    .load(it)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }
}