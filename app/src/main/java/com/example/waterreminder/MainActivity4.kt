package com.example.waterreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val reset: Button = findViewById(R.id.reset)
        val male:Button = findViewById(R.id.male)
        val female:Button = findViewById(R.id.female)

        val auth:FirebaseAuth = Firebase.auth;

        var s:String
     reset.setOnClickListener(View.OnClickListener {

         Firebase.auth.signOut()
         val intent = Intent(this,MainActivity3::class.java)
         startActivity(intent)
         finish()

     }


     )
        male.setOnClickListener(View.OnClickListener {

             s = "male";
            Toast.makeText(this, "male",Toast.LENGTH_SHORT).show()
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.child( auth.currentUser?.uid.toString()).child("gender").setValue("male")
            val intent = Intent(this,MainActivity6::class.java)
            startActivity(intent)



        })
        female.setOnClickListener(View.OnClickListener {

            s= "female";
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.child( auth.currentUser?.uid.toString()).child("gender").setValue("female")
            val intent = Intent(this,MainActivity6::class.java)
            startActivity(intent)




        })

    }
}