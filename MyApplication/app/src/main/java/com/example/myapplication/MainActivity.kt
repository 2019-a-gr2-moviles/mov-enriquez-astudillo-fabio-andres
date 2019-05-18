package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1.setOnClickListener(){
            irActividad2()
        }
    }

    fun irActividad2() {
        val intent = Intent(
            this,
            Actividad2::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        intent.putExtra("nombre","Fabio")
        intent.putExtra("edad",22)
        startActivity(intent)

    }



}


