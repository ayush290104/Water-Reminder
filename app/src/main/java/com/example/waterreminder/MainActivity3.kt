package com.example.waterreminder

import android.app.Activity
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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity3 : AppCompatActivity() {
// ...
// Initialize Firebase Auth
private lateinit var auth: FirebaseAuth
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            var intent = Intent(this,MainActivity10::class.java)
            startActivity(intent)
            finish()

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
         auth = Firebase.auth
        setContentView(R.layout.activity_main3)
        var emailid : EditText = findViewById(R.id.emai_id)
        var passwordtext:EditText = findViewById(R.id.password)

        var createAccount : Button = findViewById(R.id.create)
        var sigin : Button = findViewById(R.id.signin)
sigin.setOnClickListener(View.OnClickListener {

    val intentt = Intent(this,MainActivity5::class.java)
    startActivity(intentt)

})
        createAccount.setOnClickListener(View.OnClickListener {
            var email = emailid.text.toString()
            var password = passwordtext.text.toString()



            if (email==""||password==""){
Toast.makeText(this,"enter all credentials",Toast.LENGTH_SHORT).show()
}
else{
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser

                        val database = Firebase.database
                        val myRef = database.getReference("message")

                        myRef.child(auth.currentUser?.uid.toString()).setValue(email)
                        updateUI(user,email)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }
                }
}
        })
    }

    private fun updateUI(user: FirebaseUser?,s:String) {

var intent = Intent(this,MainActivity4::class.java)

        startActivity(intent)
        finish()}
}