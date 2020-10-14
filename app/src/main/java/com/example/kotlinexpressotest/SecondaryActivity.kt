package com.example.kotlinexpressotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

    val btnBackToMain = findViewById<Button>(R.id.btn_nav_back)

        btnBackToMain.setOnClickListener {
            onBackPressed()
        }
    }

}