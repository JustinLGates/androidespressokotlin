package com.example.kotlinexpressotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNavSecondary = findViewById<Button>(R.id.btn_nav_secondary)
        btnNavSecondary.setOnClickListener{
            val intent = Intent(this,SecondaryActivity::class.java)
            startActivity(intent)
        }

        var usergreeting = findViewById<TextView>(R.id.greeting)
        usergreeting.text = "Please Enter your name"


        val greetBtn = findViewById<Button>(R.id.greetUserBtn)
        greetBtn.setOnClickListener{
           changeText(usergreeting);
        }

    }
fun changeText( textview : TextView){
    val userName = findViewById<TextView>(R.id.usernameInput).text
    textview.text = "Hello $userName!"
}

}