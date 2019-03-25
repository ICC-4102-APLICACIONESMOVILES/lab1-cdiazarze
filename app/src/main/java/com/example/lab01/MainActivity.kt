package com.example.lab01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView




class MainActivity : AppCompatActivity() {
    val REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var activityIntent:Intent
        activityIntent = Intent(this, LoginActivity::class.java)
        mainLogOutButton.setOnClickListener {
            //Call log in activity
            startActivityForResult(activityIntent,REQUEST)
        }


        //Call log in activity
        startActivityForResult(activityIntent,REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                var message = data?.getStringExtra(LoginActivity.EMAIL)
                mainUserTextView.text = message
            }
        }

    }



}
