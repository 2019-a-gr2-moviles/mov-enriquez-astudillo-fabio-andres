package com.example.examen1erbim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_gestionar_autores.*

class GestionarAutores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_autores)

        Autor.crearListaNombres()
        println("Hola")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Autor.listaAutoresNombres)
        println("Hola2")
        lista_autores.adapter = adapter



    }



//        lista_autores.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//
//        }


}
