package com.example.praktikum_app1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class GetStartedActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var handler: Handler
    private val imageList = listOf(
        R.drawable.bg1,
        R.drawable.bg2,
        R.drawable.bg3
    )
    private var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ImageSliderAdapter(imageList)

        val btnGetStarted = findViewById<Button>(R.id.btnGetStarted)
        btnGetStarted.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        handler = Handler(Looper.getMainLooper())
        autoSlideImages()
    }

    private fun autoSlideImages() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                page = (page + 1) % imageList.size
                viewPager.currentItem = page
                handler.postDelayed(this, 3000)
            }
        }, 3000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)
    }

    override fun onResume() {
        super.onResume()
        autoSlideImages()
    }
}
