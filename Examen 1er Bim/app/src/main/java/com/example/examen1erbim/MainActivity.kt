package com.example.examen1erbim

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.os.HandlerCompat.postDelayed



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            irAAutores(it)
        }
    }

    fun irAAutores(view: View){

        Autor.nombre = editText.text.toString()
        val intentExplicito = Intent(
            this,Autores::class.java
        )
        intentExplicito.putExtra("mensaje","Bienvenid@ " + Autor.nombre)
        startActivity(intentExplicito)
    }
}
