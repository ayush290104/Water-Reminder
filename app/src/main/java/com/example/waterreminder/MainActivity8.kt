package com.example.waterreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity8 : AppCompatActivity() {
    private val auth: FirebaseAuth = Firebase.auth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        val database = Firebase.database
        val myRef = database.getReference("message")
        val imageView:ImageView = findViewById(R.id.imageView6)

     var gender :String
        var weight:String

val further:Button = findViewById(R.id.action2)
        further.alpha = 0F
        val lottieAnimationView:LottieAnimationView = findViewById(R.id.lottieAnimationView)
        val textview:TextView = findViewById(R.id.textView9)
        val button:Button = findViewById(R.id.action)
        val textview2:TextView = findViewById(R.id.textView10)
        val textview3:TextView = findViewById(R.id.textView11)
        myRef.child(auth.currentUser?.uid.toString()).child("gender").get().addOnSuccessListener {
                  textview2.text = it.value.toString()

   }

        myRef.child(auth.currentUser?.uid.toString()).child("weight").get().addOnSuccessListener {

            textview3.text= it.value.toString()
        }

   textview.alpha = 0f
        button.setOnClickListener(View.OnClickListener {
            weight = textview3.text.toString()
            gender = textview2.text.toString()
            lottieAnimationView.setAnimation(R.raw.water)

              imageView.alpha = 0F
            further.alpha = 1F
            button.alpha = 0F
            further.setOnClickListener(View.OnClickListener {

                val intent = Intent(this,MainActivity9::class.java)
                startActivity(intent)

            })

            if (gender == "male"){
 var a = weight.toInt()
   var b = a*0.0325*1000
                var c:Int = b.toInt()
                myRef.child(auth.currentUser?.uid.toString()).child("water need in ml").setValue(c.toString())
                myRef.child(auth.currentUser?.uid.toString()).child("your need").setValue(c.toString())

                textview.text = "YOU NEED TO DRINK " + c.toString() +" ml of water a day .\n Don't worry I'll remind you when to drink."


                lottieAnimationView.playAnimation()
                lottieAnimationView.loop(false)



            }
            if (gender == "female"){
                var a = weight.toInt()
                var b = a*0.0325*1000 - 200
                var c:Int = b.toInt()
                myRef.child(auth.currentUser?.uid.toString()).child("water need in ml").setValue(c.toString())
                myRef.child(auth.currentUser?.uid.toString()).child("your need").setValue(c.toString())

                textview.text = "YOU NEED TO DRINK " + c.toString() +" ml of water a day .\n Don't worry I'll remind you when to drink."



                lottieAnimationView.playAnimation()

                lottieAnimationView.loop(false)


            }
            textview.animate().apply {
                duration = 5000
                alphaBy(1f)
            }.start()

        })




}}