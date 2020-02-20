package com.xjh.bootpagedemo.scrollview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import com.xjh.bootpagedemo.MainActivity
import com.xjh.bootpagedemo.R
import kotlinx.android.synthetic.main.activity_scroll_view.*
import kotlinx.android.synthetic.main.activity_view_flipper.*
import kotlinx.android.synthetic.main.activity_view_flipper.btn

class ScrollViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

        btn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        val context = this
        scrollView.setOnScrollChangeListener(object : MyScrollView.OnScrollChangeListener {
            override fun onScrollChange(top: Int, oldTop: Int) {
                if (top > oldTop && animLLayout.visibility == View.INVISIBLE) {
                    val anim = AnimationUtils.loadAnimation(context, R.anim.show)
                    animLLayout.visibility = View.VISIBLE
                    animLLayout.startAnimation(anim)
                } else if (top < oldTop && animLLayout.visibility == View.VISIBLE) {
                    val anim = AnimationUtils.loadAnimation(context, R.anim.close)
                    animLLayout.visibility = View.INVISIBLE
                    animLLayout.startAnimation(anim)
                }
            }
        })
    }
}
