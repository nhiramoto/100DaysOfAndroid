package com.example.day1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*
import kotlin.random.Random

class ActivityA : AppCompatActivity() {

    private var activityBIntent : Intent? = null
    private val REQUEST_CODE : Int = 1

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null && requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val infoFromB = data.getStringExtra("INFO_RESULT_B")
            tvActivityA.text = infoFromB
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        tvActivityA.text = "Random from A: ${Random.nextInt(0, 100).toString()}"

        btActivityA.setOnClickListener {
            val randomNumber = "Random from A: ${Random.nextInt(0, 100).toString()}"
            if (activityBIntent == null) {
                this.activityBIntent = Intent(this, ActivityB::class.java)
            }
            this.activityBIntent?.putExtra("INFO", randomNumber)
            startActivityForResult(this.activityBIntent, REQUEST_CODE)
        }
    }
}
