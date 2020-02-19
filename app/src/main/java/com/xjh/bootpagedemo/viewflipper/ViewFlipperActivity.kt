package com.xjh.bootpagedemo.viewflipper

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.get
import com.xjh.bootpagedemo.MainActivity
import com.xjh.bootpagedemo.R
import kotlinx.android.synthetic.main.activity_view_flipper.*
import kotlinx.android.synthetic.main.activity_view_pager.*
import kotlinx.android.synthetic.main.activity_view_pager.indicator
import kotlinx.android.synthetic.main.fragment_content.view.*

class ViewFlipperActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetector
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper)
        btn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        initIndicator()
    }

    private fun initIndicator() {
        val width =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                20f,
                resources.displayMetrics
            ).toInt()
        val lp = ActionBar.LayoutParams(width, width)
        lp.rightMargin = 2 * width
        lp.leftMargin = 2 * width
        for (i in 0 until viewFlipper.childCount) {
            val view = View(this)
            view.id = i
            view.setBackgroundResource(if (i == 0) R.drawable.dot_focus else R.drawable.dot_normal)
            view.layoutParams = lp
            indicator.addView(view, i)
        }

        gestureDetector = GestureDetector(this)
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        e1?.let { a ->
            e2?.let { b ->
                if (a.x > b.x) {
                    viewFlipper.showNext()
                    index = if (index < 2) index + 1 else 0
                    changeIndicator()
                    return true
                } else if (a.x < b.x) {
                    viewFlipper.showNext()
                    index = if (index > 0) index - 1 else 2
                    changeIndicator()
                    return true
                }
            }
        }
        return false
    }

    private fun changeIndicator() {
        for (i in 0 until viewFlipper.childCount) {
            indicator[i].setBackgroundResource(
                if (i == index) R.drawable.dot_focus else R.drawable.dot_normal
            )
        }
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
}
