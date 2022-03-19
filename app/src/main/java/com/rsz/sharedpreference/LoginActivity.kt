package com.rsz.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sessionManager = SessionManager(this)

        if (sessionManager.isLogin()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            btn_login.setOnClickListener {
                val name = edt_name.text.toString()
                val pass = edt_password.text.toString()

                if (name.isNullOrEmpty()){
                    Toast.makeText(this, "Nama Harus Terisi", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (pass.isNullOrEmpty()){
                    Toast.makeText(this, "Password Harus Terisi", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                sessionManager.sessionLogin(name,pass)

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}