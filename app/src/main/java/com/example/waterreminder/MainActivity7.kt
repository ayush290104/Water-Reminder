package com.example.waterreminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        val wakeup:EditText = findViewById(R.id.wakeup)
        val sleep:EditText = findViewById(R.id.sleep)
        val nexttime:Button = findViewById(R.id.nexttime)

        val auth: FirebaseAuth = Firebase.auth;
        nexttime.setOnClickListener(View.OnClickListener {

            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.child( auth.currentUser?.uid.toString()).child("wakeup").setValue(wakeup.text.toString())
            myRef.child( auth.currentUser?.uid.toString()).child("sleep").setValue(sleep.text.toString())


        })

    }
}