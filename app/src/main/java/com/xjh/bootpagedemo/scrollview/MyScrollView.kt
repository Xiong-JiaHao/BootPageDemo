package com.xjh.bootpagedemo.scrollview

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView

class MyScrollView(context: Context, attrs: AttributeSet?) : ScrollView(context, attrs) {

    private lateinit var onScrollViewListener: OnScrollChangeListener

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        onScrollViewListener.onScrollChange(t, oldt)
    }

    interface OnScrollChangeListener {
        fun onScrollChange(top: Int, oldTop: Int)
    }

    fun setOnScrollChangeListener(onScrollChangeListener: OnScrollChangeListener) {
        this.onScrollViewListener = onScrollChangeListener
    }
}