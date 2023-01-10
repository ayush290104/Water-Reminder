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
            if (wakeup.text.toString().toInt()>24||wakeup.text.toString().toInt()<0||sleep.text.toString().toInt()>24||sleep.text.toString().toInt()<0||sleep.text.toString()==""||wakeup.text.toString()==""){
                Toast.makeText(this,"Enter correct time details",Toast.LENGTH_SHORT).show()

            }




else {
                myRef.child(auth.currentUser?.uid.toString()).child("wakeup")
                    .setValue(wakeup.text.toString())
                myRef.child(auth.currentUser?.uid.toString()).child("sleep")
                    .setValue(sleep.text.toString())
                val intent = Intent(this, MainActivity8::class.java)
                startActivity(intent)


            }
        })

    }
}