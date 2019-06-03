package com.example.examen1erbim

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_gestionar_autores.*
import kotlinx.android.synthetic.main.activity_gestionar_libros.*

class GestionarLibros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_libros)

        val pos: Int = intent.getIntExtra("pos", 0)

        Autor.listaAutores.get(pos).crearListaNombres()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Autor.listaAutores.get(pos).nombresLibros)

        list_libros.adapter = adapter
        list_libros.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intentExplicito = Intent(
                this,GestionarLibro::class.java
            )
            intentExplicito.putExtra("pos", pos)
            intentExplicito.putExtra("pos2", position)
            startActivity(intentExplicito)
        }
    }
}
