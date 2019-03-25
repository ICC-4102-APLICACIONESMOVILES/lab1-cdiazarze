package com.example.lab01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.security.KeyStore
import android.app.Activity

class LoginActivity : AppCompatActivity() {

    companion object {
        val EMAIL= "EMAIL"
        val PASS = "PASS"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setListeners()



    }

    private fun setListeners() {
        loginLogButton.setOnClickListener {
            if (loginUserMailEdit.text.toString().isValidEmail() && loginPassEdit.text.isNotEmpty()) {
                val result = Intent()
                result.putExtra(EMAIL, loginUserMailEdit.text.toString())
                result.putExtra(PASS, loginPassEdit.text.toString())
                setResult(Activity.RESULT_OK, result)
                finish()
            } else {
                if (!loginUserMailEdit.text.toString().isValidEmail()){
                    Toast.makeText(this, "Invalid email", Toast.LENGTH_LONG).show()
                }
                if (!loginPassEdit.text.isNotEmpty()){
                    Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show()
                }
            }
        }
    }




    fun String.isValidEmail(): Boolean{
        if (this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()){ return true}
        else {return false}
    }
}
