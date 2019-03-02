package com.example.day2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val email = intent.getStringExtra("EMAIL")
        val password = intent.getStringExtra("PASSWORD")
        tvEmail.text = email
        tvPassword.text = password
    }
}
