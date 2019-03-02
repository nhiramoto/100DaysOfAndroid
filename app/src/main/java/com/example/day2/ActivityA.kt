package com.example.day2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    private var activityBIntent : Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        btActivityA.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (activityBIntent == null) {
                activityBIntent = Intent(this, ActivityB::class.java)
            }
            activityBIntent?.putExtra("EMAIL", email)
            activityBIntent?.putExtra("PASSWORD", password)
            startActivity(activityBIntent)
        }
    }
}
