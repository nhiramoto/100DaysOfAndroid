package com.example.day4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        sbRange.setOnSeekBarChangeListener(this)
        tvValue.text = sbRange.progress.toString()
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if (progress in 40..45) {
            tvRange.text = resources.getString(R.string.between4045)
        } else {
            tvRange.text = ""
        }
        tvValue.text = progress.toString()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}
