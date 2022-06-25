package com.mukisasamuel.myauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
       auth = FirebaseAuth.getInstance()

    }
    fun forgot(view:View) {
        val email = findViewById<EditText>(R.id.email1).text.toString()
        auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if(task.isSuccessful) {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    fun back (view: View){
        val intent =
            Intent(this,LoginActivity::class.java)
        startActivity(intent)

    }
}