package com.example.day1

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_b.*
import kotlin.random.Random

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val info = intent.getStringExtra("INFO")
        tvActivityB.text = info

        btActivityB.setOnClickListener {
            val randomNumber = "Random from B: ${Random.nextInt(0, 100)}"
            intent.putExtra("INFO_RESULT_B", randomNumber)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
