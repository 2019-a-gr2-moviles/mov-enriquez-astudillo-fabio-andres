package com.example.examen1erbim

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_autores.*
import kotlinx.android.synthetic.main.activity_crear_autores.*
import java.util.*

class CrearAutores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_autores)

        btn_autor.setOnClickListener {
            crearAutor()
        }

    }

    fun crearAutor(){
        val autor1: Autor = Autor(input_nombre.text.toString(), input_apellido.text.toString(), input_fecha.text.toString(), input_ec.isChecked())

        val intentExplicito = Intent(
            this,Autores::class.java
        )
        intentExplicito.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentExplicito)
    }
}
