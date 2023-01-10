package com.example.waterreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        val next : Button = findViewById(R.id.waterlife)
        val imageView:ImageView = findViewById(R.id.imageView7)
        val textView:TextView = findViewById(R.id.textView14)
        val textView2:TextView = findViewById(R.id.textView15)
        val textView3:TextView = findViewById(R.id.textView12)
        textView.alpha = 0F
        textView2.alpha = 0F
        next.alpha = 0f
        imageView.setOnClickListener(View.OnClickListener {
            next.alpha = 1f
            next.setOnClickListener(View.OnClickListener {
                val intent = Intent(this,MainActivity10::class.java)
                startActivity(intent)

            })

            textView3.animate().apply {
                duration = 1000
                alphaBy(0f)
            }.start()


            textView.animate().apply {
                duration = 3000
                  alphaBy(1f)
            }.start()
textView2.animate().apply {
    duration = 3000
    alphaBy(1f)
}.start()



        })


    }
}