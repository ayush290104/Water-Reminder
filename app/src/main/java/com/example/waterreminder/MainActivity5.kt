package com.example.waterreminder

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity5 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        auth = Firebase.auth

        val emailaddress : EditText = findViewById(R.id.editTextTextEmailAddress)
        val passwordlogin : EditText = findViewById(R.id.editTextTextPassword)
        val signin : Button = findViewById(R.id.login)
        signin.setOnClickListener(View.OnClickListener {
            val email = emailaddress.text.toString()
            val password = passwordlogin.text.toString()
            if (email==""||password==""){
                Toast.makeText(this,"enter all credentials",Toast.LENGTH_SHORT).show()
            }
            else{
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        val intent = Intent(this,MainActivity4::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Invalid Credentials",
                            Toast.LENGTH_SHORT).show()

                    }
                }
            }

        })
    }
}