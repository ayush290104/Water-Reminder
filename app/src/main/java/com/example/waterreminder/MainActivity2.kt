package com.example.waterreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val time: Long = 1000
        Handler().postDelayed(Runnable {
            val intent = Intent(MainActivity2@this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, time)
    }
}