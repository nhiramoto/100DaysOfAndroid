package com.example.day8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val username = intent.getStringExtra("USERNAME")
        tvUsername.text = username

        btLogout.setOnClickListener {
            finish()
        }
    }
}
