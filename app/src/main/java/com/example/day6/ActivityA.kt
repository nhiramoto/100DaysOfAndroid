package com.example.day6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        btDisplayValues.setOnClickListener {
            fun checkBoxReport(cb : CheckBox) : String {
                when (cb.isChecked) {
                    true -> return "${cb.text}, "
                    false -> return ""
                }
            }
            val checkBoxes = arrayOf(cbFirst, cbSecond, cbThird, cbFour)
            var message = ""
            checkBoxes.forEachIndexed { ind, cb ->
                message = "$message${checkBoxReport(cb)}"
            }
            if (message.isBlank()) {
                message = resources.getString(R.string.selectedNone)
            }
            tvResult.text = message.trim(',', ' ')
        }
    }
}
