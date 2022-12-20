package com.example.waterreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.button)
        val database = Firebase.database
        val myRef = database.getReference("message")
        button.setOnClickListener(View.OnClickListener {

            val intent2 = Intent(MainActivity@this,MainActivity3::class.java)
            startActivity(intent2)

        })
    }
}