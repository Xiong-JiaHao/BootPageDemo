package com.xjh.bootpagedemo.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.xjh.bootpagedemo.MainActivity
import com.xjh.bootpagedemo.R

class SplashActivity : AppCompatActivity() {

    companion object {
        private val DELAY_TIME = 3000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, DELAY_TIME)
    }
}
