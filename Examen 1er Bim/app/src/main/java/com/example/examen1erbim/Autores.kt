package com.example.examen1erbim

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_autores.*

class Autores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autores)

        val mensaje = intent.getStringExtra("mensaje")

        Snackbar
            .make(findViewById(android.R.id.content), mensaje, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

        btn_gestionar_autor.setOnClickListener {
            irAGestionarAutores()
        }

        btn_crear_autor.setOnClickListener {
            irACrearAutores()
        }
    }

    fun irAGestionarAutores(){
        val intentExplicito = Intent(
            this,GestionarAutores::class.java
        )
        startActivity(intentExplicito)
    }

    fun irACrearAutores(){
        val intentExplicito = Intent(
            this,CrearAutores::class.java
        )
        startActivity(intentExplicito)
    }
}
