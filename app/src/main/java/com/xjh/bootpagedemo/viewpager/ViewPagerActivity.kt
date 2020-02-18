package com.xjh.bootpagedemo.viewpager

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.core.view.get
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.xjh.bootpagedemo.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var adapter: PagerAdapter
    private val fragments = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        for (index in 0..2) {
            val fragment = ContentFragment()
            val bundle = Bundle()
            bundle.putInt("index", index)
            fragment.arguments = bundle
            fragments.add(fragment)
        }

        adapter = ViewPagerAdapter(supportFragmentManager, fragments)
        viewPager.adapter = adapter
        initIndicator()
        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                for (i in 0 until fragments.size) {
                    indicator[i].setBackgroundResource(
                        if (i == position) R.drawable.dot_focus else R.drawable.dot_normal
                    )
                }
            }

            override fun onPageSelected(position: Int) {

            }

        })
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
        for (i in 0 until fragments.size) {
            val view = View(this)
            view.id = i
            view.setBackgroundResource(if (i == 0) R.drawable.dot_focus else R.drawable.dot_normal)
            view.layoutParams = lp
            indicator.addView(view, i)
        }
    }


}
