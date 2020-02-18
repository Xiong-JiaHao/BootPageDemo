package com.xjh.bootpagedemo.viewpager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xjh.bootpagedemo.MainActivity
import com.xjh.bootpagedemo.R
import kotlinx.android.synthetic.main.fragment_content.view.*

class ContentFragment : Fragment() {

    private val bgRes = arrayOf(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_content, null)
        arguments?.getInt("index")?.let {
            view.contentRLayout.setBackgroundColor(bgRes[it])
            view.btn.setOnClickListener {
                startActivity(Intent(activity, MainActivity::class.java))
            }
            view.btn.visibility = if (it == 2) View.VISIBLE else View.GONE
        }
        return view
    }
}