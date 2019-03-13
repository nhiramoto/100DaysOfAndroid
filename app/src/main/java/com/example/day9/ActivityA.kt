package com.example.day9

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityA : AppCompatActivity() {

    private lateinit var dbHelper: SpinnerDbHelper
    private lateinit var db : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        dbHelper = SpinnerDbHelper(this)
        db = dbHelper.writableDatabase
        populateDb(db, listOf("Pizza", "Salad", "Soup", "Rice with Sauce", "Noodles", "Baked Potato", "Bulgar"))
    }

    fun populateDb(db : SQLiteDatabase, food_names : List<String>) {
        var row : ContentValues
        for (f in food_names) {
            row = ContentValues().apply {
                put(SpinnerDatabaseContract.SpinnerData.COLUMN_NAME_FOOD_NAME, f)
            }
            db.insert(SpinnerDatabaseContract.SpinnerData.TABLE_NAME, null, row)
        }
    }
}
