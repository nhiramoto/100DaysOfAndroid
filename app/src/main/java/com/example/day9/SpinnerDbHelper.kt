package com.example.day9

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object SpinnerDatabaseContract {
    object SpinnerData : BaseColumns {
        const val TABLE_NAME = "spinner_data"
        const val COLUMN_NAME_FOOD_NAME = "food_name"
    }
    internal const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${SpinnerData.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${SpinnerData.COLUMN_NAME_FOOD_NAME} TEXT)"
    internal const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${SpinnerData.TABLE_NAME}"
}

class SpinnerDbHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SpinnerDatabaseContract.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SpinnerDatabaseContract.SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Spinner.db"
    }
}