package com.example.examen1erbim

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_crear_libros.*
import kotlinx.android.synthetic.main.activity_gestionar_autor.*
import kotlinx.android.synthetic.main.activity_gestionar_libro.*
import kotlinx.android.synthetic.main.activity_gestionar_libro.input2_editorial
import kotlinx.android.synthetic.main.activity_gestionar_libro.input2_isbn

class GestionarLibro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_libro)

        val pos = intent.getIntExtra("pos",0)
        val pos2 = intent.getIntExtra("pos2",0)



//        input2_isbn.setText(Autor.listaAutores.get(pos).libros.get(pos2).ICBN)
//        input2_nombre.setText(Autor.listaAutores.get(pos).libros.get(pos2).nombre)
//        input2_pags.setText(Autor.listaAutores.get(pos).libros.get(pos2).numeroPaginas)
//        input2_edicion.setText(Autor.listaAutores.get(pos).libros.get(pos2).edicion)
//        input2_fecha.setText(Autor.listaAutores.get(pos).libros.get(pos2).fechaPublicacion)
//        input2_editorial.setText(Autor.listaAutores.get(pos).libros.get(pos2).nombreEditorial)
//        input2_numero.setText(pos2)

        btn_eliminar.setOnClickListener {
            eliminar(pos, pos2)
        }

        btn_actualizar.setOnClickListener {
            actualizar(pos, pos2)
        }
    }

    fun eliminar(pos:Int, pos2:Int){
        Autor.listaAutores.get(pos).libros.removeAt(pos2)
        val intentExplicito = Intent(
            this,GestionarAutor::class.java
        )
        intentExplicito.putExtra("pos", pos)
        intentExplicito.putExtra("mensaje", Autor.nombre+ ", se ha eliminado un Libro")
        intentExplicito.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentExplicito)
    }

    fun actualizar(pos:Int, pos2:Int){
        Autor.listaAutores.get(pos).libros.get(pos2).ICBN = input2_isbn.text.toString().toInt();
        Autor.listaAutores.get(pos).libros.get(pos2).nombre = input2_nombre.text.toString();
        Autor.listaAutores.get(pos).libros.get(pos2).edicion = input2_edicion.text.toString().toInt();
        Autor.listaAutores.get(pos).libros.get(pos2).fechaPublicacion = input2_fecha.text.toString();
        Autor.listaAutores.get(pos).libros.get(pos2).nombreEditorial = input2_editorial.text.toString();
        Autor.listaAutores.get(pos).libros.get(pos2).numeroPaginas = input2_pags.text.toString().toInt();

        Snackbar
            .make(findViewById(android.R.id.content), Autor.nombre + ", se ha actualizado el Libro", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }
}
