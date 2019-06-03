package com.example.parcial1_00118717

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1_00118717.dao.matchEntitie

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLog = findViewById(R.id.btnLog) as Button
        var btn = findViewById(R.id.btnReg) as Button
        var user = findViewById(R.id.username) as  EditText
        var pass = findViewById(R.id.pass) as  EditText
        btn.setOnClickListener(){
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        btnLog.setOnClickListener(){
            val mintent = Intent(this, HomeActivity::class.java)
            startActivity(mintent)

        }
    }
}
