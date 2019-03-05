package com.example.day3

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val arrayAdapter = object : ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.activityAOptions)) {
            override fun isEnabled(position: Int): Boolean {
                return position > 0
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view : View = super.getDropDownView(position, convertView, parent)
                val tv : TextView = view as TextView
                if (position == 0) {
                    tv.setTextColor(Color.GRAY)
                } else {
                    tv.setTextColor(Color.BLACK)
                }
                return tv
            }
        }

        spOptions.adapter = arrayAdapter

        btActivityA.setOnClickListener {
            if (spOptions.selectedItemPosition != 0) {
                tvActivityA.text = spOptions.selectedItem.toString()
            } else {
                Toast.makeText(this, R.string.selectAnOption, Toast.LENGTH_LONG).show()
            }
        }
    }

}
