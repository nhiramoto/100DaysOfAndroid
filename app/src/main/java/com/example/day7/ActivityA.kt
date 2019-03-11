package com.example.day7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        btToggleVisibility.setOnClickListener {
            if (ivSampleImage.visibility == ImageView.INVISIBLE) {
                ivSampleImage.visibility = ImageView.VISIBLE
                btToggleVisibility.text = resources.getString(R.string.hideImage)
            } else {
                ivSampleImage.visibility = ImageView.INVISIBLE
                btToggleVisibility.text = resources.getString(R.string.showImage)
            }
        }
    }
}
