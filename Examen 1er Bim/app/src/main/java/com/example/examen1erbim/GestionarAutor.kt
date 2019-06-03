package com.example.examen1erbim

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gestionar_autor.*

class GestionarAutor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_autor)

        val pos = intent.getIntExtra("pos",0)
        println(pos)

        input_nombre2.setText(Autor.listaAutores.get(pos).nombres)
        input_apell2.setText(Autor.listaAutores.get(pos).apellidos)
        input_fech2.setText(Autor.listaAutores.get(pos).fechaNacimiento)
        input_ecu2.isChecked = Autor.listaAutores.get(pos).ecuatoriano
        input_numLib2.setText(Autor.listaAutores.get(pos).numeroLibros.toString())

        btn_cre_lib.setOnClickListener {
            irACrearLib(pos)
        }

        btn_gest_lib.setOnClickListener {
            irAGestLib(pos)
        }

        btn_act.setOnClickListener {
            actualizar(pos)
        }

        btn_elim.setOnClickListener {
            eliminar(pos)
        }
    }
    fun irAGestLib(pos:Int){
        val intentExplicito = Intent(
            this,GestionarLibros::class.java
        )
        intentExplicito.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intentExplicito.putExtra("pos", pos)
        startActivity(intentExplicito)
    }

    fun irACrearLib(pos:Int){
        val intentExplicito = Intent(
            this,CrearLibros::class.java
        )
        intentExplicito.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intentExplicito.putExtra("pos", pos)
        startActivity(intentExplicito)
    }

    fun eliminar(pos:Int){
        Autor.listaAutores.removeAt(pos)
        val intentExplicito = Intent(
            this,GestionarAutores::class.java
        )
        intentExplicito.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentExplicito)
    }

    fun actualizar(pos:Int){
        Autor.listaAutores.get(pos).nombres = input_nombre2.text.toString();
        Autor.listaAutores.get(pos).apellidos = input_apell2.text.toString();
        Autor.listaAutores.get(pos).fechaNacimiento = input_fech2.text.toString();
        Autor.listaAutores.get(pos).ecuatoriano = input_ecu2.isChecked;
        val intentExplicito = Intent(
            this,GestionarAutores::class.java
        )
        intentExplicito.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentExplicito)
    }

}
