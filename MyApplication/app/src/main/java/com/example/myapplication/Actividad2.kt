package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad2.*

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        val nombre: String? = intent.getStringExtra("nombre")
        val edad: Int? = intent.getIntExtra("edad",0)
        Log.i("intents","Nombre: $nombre")
        Log.i("intents","Edad: $edad")

        boton2.setOnClickListener(){
            irActividad1()
        }
    }

    fun irActividad1() {
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
    }


}
