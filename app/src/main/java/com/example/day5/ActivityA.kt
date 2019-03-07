package com.example.day5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            rbFirst.id -> tvSelection.text = resources.getString(R.string.selectedFirst)
            rbSecond.id -> tvSelection.text = resources.getString(R.string.selectedSecond)
            rbThird.id -> tvSelection.text = resources.getString(R.string.selectedThird)
            rbForth.id -> tvSelection.text = resources.getString(R.string.selectedForth)
            else -> tvSelection.text = resources.getString(R.string.selectedNothing)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        rgMain.setOnCheckedChangeListener(this)
    }
}
