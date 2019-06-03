package com.example.parcial1_00118717

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var back = findViewById(R.id.lblBack) as TextView
        back.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
