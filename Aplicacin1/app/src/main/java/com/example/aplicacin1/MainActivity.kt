package com.example.aplicacin1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.setOnClickListener {
            irAListView()
        }
    }

    fun irAListView(){
        val intentExplicito = Intent(
            this,ListViewActivity::class.java
        )
        startActivity(intentExplicito)
    }


}



