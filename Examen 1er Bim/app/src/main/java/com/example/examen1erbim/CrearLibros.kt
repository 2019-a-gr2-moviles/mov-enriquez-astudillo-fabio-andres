package com.example.examen1erbim

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crear_libros.*

class CrearLibros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_libros)

        val pos: Int = intent.getIntExtra("pos", 0)

        btn_crearLibro.setOnClickListener {
            crearLibro(pos)
        }
    }

    fun crearLibro(pos: Int){
        val libro1: Libro = Libro(input2_isbn.text.toString().toInt(),
                                    input_nombre.text.toString(),
                                    input_numPag.text.toString().toInt(),
                                    input_edicion.text.toString().toInt(),
                                    input_fecha.text.toString(),
                                    input2_editorial.text.toString(),
                                    pos
            )
        
        val intentExplicito = Intent(
            this,GestionarAutor::class.java
        )
        intentExplicito.putExtra("mensaje", Autor.nombre+", se ha creado un libro")
        intentExplicito.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentExplicito)
    }
}
