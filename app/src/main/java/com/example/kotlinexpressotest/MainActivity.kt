package com.example.kotlinexpressotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNavSecondary = findViewById<Button>(R.id.btn_nav_secondary)
        btnNavSecondary.setOnClickListener{
            val intent = Intent(this,SecondaryActivity::class.java)
            startActivity(intent)
        }
        btnNavSecondary.setVisibility(View.GONE);

        var usergreeting = findViewById<TextView>(R.id.greeting)
        usergreeting.text = "Please login to continue"


        var nameInput = findViewById<TextView>(R.id.username_edit_field)
        var passwordInput = findViewById<TextView>(R.id.password_edit_field)


        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener{
           changeText(usergreeting)
            btnNavSecondary.setVisibility(View.VISIBLE);
            loginButton.setVisibility(View.GONE);
            nameInput.setVisibility(View.GONE);
            passwordInput.setVisibility(View.GONE);

        }

    }
fun changeText( textview : TextView){
    val userName = findViewById<TextView>(R.id.username_edit_field).text
    textview.text = "Hello $userName!"
}

}