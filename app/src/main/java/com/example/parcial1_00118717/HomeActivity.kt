package com.example.parcial1_00118717

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var btnCreate = findViewById(R.id.btnCreate) as Button
        var btnResult = findViewById(R.id.btnResult) as Button
        btnCreate.setOnClickListener(){
            val mintent = Intent(this, createMatch::class.java)
            startActivity(mintent)

        }
        btnResult.setOnClickListener(){
            val mintent1 = Intent(this, showMatches::class.java)
            startActivity(mintent1)

        }

    }
}
