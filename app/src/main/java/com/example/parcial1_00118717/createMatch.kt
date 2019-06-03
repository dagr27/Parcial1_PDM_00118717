package com.example.parcial1_00118717

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.parcial1_00118717.dao.matchDao
import com.example.parcial1_00118717.dao.matchEntitie
import java.text.SimpleDateFormat
import java.util.*

class createMatch() : AppCompatActivity() {
    var score = 0
    var score3 = 0
    private lateinit var dao: matchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_match)

        var team1 = findViewById(R.id.txtTeam1) as EditText
        var team2 = findViewById(R.id.txtTeam2) as EditText

        var btn1 = findViewById(R.id.btn1s1) as Button
        var btn2 = findViewById(R.id.btn1s2) as Button
        var btn3 = findViewById(R.id.btn1s3) as Button

        var btn4 = findViewById(R.id.btn2s1) as Button
        var btn5 = findViewById(R.id.btn2s2) as Button
        var btn6 = findViewById(R.id.btn2s3) as Button

        var goback = findViewById(R.id.goBack) as Button
        var save = findViewById(R.id.btnResult) as Button

        var score1 = findViewById(R.id.score1) as TextView
        var score2 = findViewById(R.id.score2) as TextView
        btn1.setOnClickListener(){
            score += 1
            score1.setText(score.toString())
        }
        btn2.setOnClickListener(){
            score += 2
            score1.setText(score.toString())
        }
        btn3.setOnClickListener(){
            score += 3
            score1.setText(score.toString())
        }

        btn4.setOnClickListener(){
            score3 += 1
            score2.setText(score3.toString())
        }
        btn5.setOnClickListener(){
            score3 += 2
            score2.setText(score3.toString())
        }
        btn6.setOnClickListener(){
            score3 += 3
            score2.setText(score3.toString())
        }
        goback.setOnClickListener(){
            score=0
            score3=0
            score1.setText("-")
            score2.setText("-")
            team1.setText("Team1")
            team2.setText("Team2")

        }
        save.setOnClickListener {
            val replyIntent = Intent()
            val team1 = findViewById(R.id.txtTeam1) as EditText
            val team2 = findViewById(R.id.txtTeam2) as EditText
            var date = SimpleDateFormat("yyyy/mm/dd", Locale.getDefault()).toString()
            val data = matchEntitie(0,team1.text.toString(),team2.text.toString(),score,score3,date)
            dao.insert(data)



        }

    }

}
