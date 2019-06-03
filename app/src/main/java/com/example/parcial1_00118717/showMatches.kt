package com.example.parcial1_00118717

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class showMatches : AppCompatActivity() {
    private lateinit var matchViewModel: matchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_matches)
        val recyclerView = findViewById(R.id.recyclerview1) as RecyclerView
        val adapter = matchAdapter(this)
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        matchViewModel = ViewModelProviders.of(this).get(matchViewModel::class.java)
        matchViewModel.allMatches.observe(this, Observer {
            match -> match?.let { adapter.setMatches(it) }
        })




    }
}
