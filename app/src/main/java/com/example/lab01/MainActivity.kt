package com.example.lab01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import kotlinx.android.synthetic.main.activity_main.*
import android.R
import android.widget.TextView




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var activityIntent:Intent

        // Get the Intent that started this activity and extract the string
        var intent = intent
        var message = intent.getStringExtra(LoginActivity.email)

        // Capture the layout's TextView and set the string as its text
        mainUserTextView.setText(message)

        if (mainUserTextView.text.isEmpty()) {
            activityIntent = Intent(this, LoginActivity::class.java)
            //Call log in activity
            startActivity(activityIntent)
            finish()
        }

    }


}
