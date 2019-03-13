package com.example.day9

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    private lateinit var dbHelper: SpinnerDbHelper
    private lateinit var dbWritable : SQLiteDatabase
    private lateinit var dbReadable : SQLiteDatabase
    private val myPrefs = "myPrefs"
    private val isFirstTimeKey = "isFirstTime"
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var prefEditor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        dbHelper = SpinnerDbHelper(this)
        dbWritable = dbHelper.writableDatabase
        dbReadable = dbHelper.readableDatabase

        sharedPreferences = getSharedPreferences(myPrefs, Context.MODE_PRIVATE)
        prefEditor = sharedPreferences.edit()
        val isFirstTime = sharedPreferences.getBoolean(isFirstTimeKey, true)
        if (isFirstTime) {
            populateDb(dbWritable, listOf("Pizza", "Salad", "Soup", "Rice with Sauce", "Noodles", "Baked Potato", "Bulgar"))
            prefEditor.putBoolean(isFirstTimeKey, false)
            prefEditor.commit()
        }
        fillSpinner(dbReadable, spFoods)
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

    fun populateDb(db : SQLiteDatabase, foodNames : List<String>) {
        var row : ContentValues
        for (foodName in foodNames) {
            row = ContentValues().apply {
                put(SpinnerDatabaseContract.SpinnerData.COLUMN_NAME_FOOD_NAME, foodName)
            }
            db.insert(SpinnerDatabaseContract.SpinnerData.TABLE_NAME, null, row)
        }
    }

    fun fillSpinner(db : SQLiteDatabase, spinner : Spinner) {
        val projection = arrayOf(SpinnerDatabaseContract.SpinnerData.COLUMN_NAME_FOOD_NAME)
        val cursor = db.query(
            SpinnerDatabaseContract.SpinnerData.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        val foodNames = mutableListOf<String>()
        with (cursor) {
            while(moveToNext()) {
                val foodName = getString(getColumnIndexOrThrow(SpinnerDatabaseContract.SpinnerData.COLUMN_NAME_FOOD_NAME))
                foodNames.add(foodName)
            }
        }
        val spinnerArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, foodNames)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerArrayAdapter
    }
}
