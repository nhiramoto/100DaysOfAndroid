package com.example.day8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    private val myPrefs = "myPrefs"
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var prefEditor : SharedPreferences.Editor
    private lateinit var activityBIntent : Intent
    private lateinit var errorDialog : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        sharedPreferences = getSharedPreferences(myPrefs, Context.MODE_PRIVATE)
        prefEditor = sharedPreferences.edit()
        activityBIntent = Intent(this, ActivityB::class.java)
        errorDialog = createErrorDialog()

        populatePreferences()

        btLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val expectedPassword : String? = sharedPreferences.getString(username, null)
            if (expectedPassword == password) {
                etUsername.text.clear()
                etPassword.text.clear()
                activityBIntent.putExtra("USERNAME", username)
                startActivity(activityBIntent)
            } else {
                errorDialog.show()
            }
        }
    }

    private fun populatePreferences() {
        prefEditor.putString("John", "1234")
        prefEditor.putString("Vanessa", "4321")
        prefEditor.putString("Richard", "321")
        prefEditor.commit()
    }

    private fun createErrorDialog() : AlertDialog {
        val errorDialogBuilder = AlertDialog.Builder(this@ActivityA)
        errorDialogBuilder.setTitle(resources.getString(R.string.loginError))
        errorDialogBuilder.setMessage(resources.getString(R.string.incorrectUsernameOrPassword))
        errorDialogBuilder.setNeutralButton("OK"){ _,_ -> }
        return errorDialogBuilder.create()
    }
}
