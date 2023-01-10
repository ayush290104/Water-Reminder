package com.example.waterreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)
        val calendar = Calendar.getInstance()
        val currentday = calendar.get(Calendar.DAY_OF_MONTH)
        val settings = getSharedPreferences("PRESS",0)
        val lastday = settings.getInt("day",0)
        val reset:Button = findViewById(R.id.reset2)
        val auth: FirebaseAuth = Firebase.auth;
        val textview:TextView = findViewById(R.id.textView13)
        val database = Firebase.database
        val add:Button =findViewById(R.id.Addwater)
        val drank:EditText = findViewById(R.id.wateradded)
        val myRef = database.getReference("message")
       if (lastday!=currentday){
            val editor = settings.edit()
            editor.putInt("day",currentday)
            editor.commit()

            myRef.child(auth.currentUser?.uid.toString()).child("your need").get().addOnSuccessListener {
                textview.text = it.value.toString()

                myRef.child(auth.currentUser?.uid.toString()).child("water need in ml")
                    .setValue(it.value.toString())
            }


        }

        myRef.child(auth.currentUser?.uid.toString()).child("water need in ml").get().addOnSuccessListener {
            textview.text = it.value.toString()

        }
        add.setOnClickListener(View.OnClickListener {


            if(drank.text.toString()==" "){
                Toast.makeText(this,"Enter amount of water you drank",Toast.LENGTH_SHORT).show()
            }
            else {
                val a = textview.text.toString()
                val b = drank.text.toString()
                val c = a.toInt() - b.toInt()
                if (c <= 0) {
                    myRef.child(auth.currentUser?.uid.toString()).child("water need in ml")
                        .setValue("0")
                    myRef.child(auth.currentUser?.uid.toString()).child("water need in ml").get()
                        .addOnSuccessListener {
                            textview.text = it.value.toString()

                        }

                } else {
                    myRef.child(auth.currentUser?.uid.toString()).child("water need in ml")
                        .setValue(c.toString())

                    myRef.child(auth.currentUser?.uid.toString()).child("water need in ml").get()
                        .addOnSuccessListener {
                            textview.text = it.value.toString()
                        }
                }
            }







        })


        reset.setOnClickListener(View.OnClickListener {



            val intent = Intent(this,MainActivity4::class.java)
            startActivity(intent)
            finish()})
    }








}