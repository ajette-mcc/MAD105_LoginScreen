package com.example.mad105_loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val int: Int) {
            login( 1),
            password( 2),
            success( 0)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idUsername)
        val txtPassword = findViewById<TextView>(R.id.idPasswordText)
        val btnLogin = findViewById<Button>(R.id.idBtnLogin)

        btnLogin.setOnClickListener{
            when(CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())){
                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMsgLogin), Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMsgPwd), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }
                else -> {
                    startActivity(Intent(this@MainActivity, MainClassList::class.java))
                //                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "al"
        val holdPass = "jet"

        if (holdLogin != txtLogin) {
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword) {
            LoginSuccess.password
        }
        else LoginSuccess.success
    }
}