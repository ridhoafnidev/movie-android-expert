package com.dailyapps.dicodingmoviedbketpackpro.utils.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.dailyapps.dicodingmoviedbketpackpro.R
import com.dailyapps.dicodingmoviedbketpackpro.utils.commons.Constants
import com.dailyapps.dicodingmoviedbketpackpro.utils.commons.Logs

class AmTextView: AppCompatTextView {

    private var fontStyle: Int = 0
    private var fontName: Int = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setValues(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        setFont(fontStyle, fontName)
        setNewTypeFace()
    }

    private fun setNewTypeFace() {
        val font = Typeface.createFromAsset(context.assets, Constants.View.Name[fontName] + Constants.View.Style[fontStyle] + Constants.View.Type)
        setTypeface(font, Typeface.NORMAL)
    }

    @SuppressLint("CustomViewStyleable")
    private fun setValues(attrs: AttributeSet?) {
        val attr = context.obtainStyledAttributes(attrs, R.styleable.AmView)
        try {
            val n = attr.indexCount
            for (i in 0 until n) {
                when (val attribute = attr.getIndex(i)) {
                    R.styleable.AmView_am_font_style-> fontStyle = attr.getInt(attribute, 0)
                    R.styleable.AmView_am_font_family-> fontName = attr.getInt(attribute, 0)
                    else -> Logs.i("$javaClass: $attribute")
                }
            }
        } finally {
            attr.recycle()
        }
    }

    private fun setFont(font: Int, name: Int) {
        fontStyle = font
        fontName = name
    }

}