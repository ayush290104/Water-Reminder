package com.example.waterreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val auth: FirebaseAuth = Firebase.auth;
        val weight:EditText = findViewById(R.id.wakeup)
        var weigh : String
        val next:Button =findViewById(R.id.nexttime)
        next.setOnClickListener(View.OnClickListener {
            weigh = weight.text.toString();
            if(weigh.toInt()<0||weigh == ""){
                Toast.makeText(this,"Enter your correct weight",Toast.LENGTH_SHORT).show()
            }
            else {
                val database = Firebase.database
                val myRef = database.getReference("message")

                myRef.child(auth.currentUser?.uid.toString()).child("weight").setValue(weigh)
                val intent = Intent(this, MainActivity7::class.java)
                startActivity(intent)
            }
        })
    }
}