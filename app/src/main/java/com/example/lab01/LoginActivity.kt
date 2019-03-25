package com.example.lab01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.security.KeyStore

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setListeners()



    }

    private fun setListeners() {
        loginLogButton.setOnClickListener {
            if (loginUserMailEdit.text.toString().isValidEmail() && loginPassEdit.text.isNotEmpty()) {
                var mainActivityIntent: Intent = Intent(this, MainActivity::class.java)
                startActivity(mainActivityIntent.apply {
                    putExtra("email",loginUserMailEdit.text.toString())
                })
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
