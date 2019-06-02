package com.example.examen1erbim

import java.util.*
import kotlin.collections.ArrayList

class Autor
(
    val nombres: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val ecuatoriano: Boolean,
    val id: Int
)


{

    val libros: ArrayList<Libro> = ArrayList<Libro>();
    var numeroLibros: Int


    init {
        numeroLibros = 0
        Autor.listaAutores.add(this)
    }

    fun cambiarNumeros(){
        this.numeroLibros = libros.size
    }

    companion object{
        val listaAutores = ArrayList<Autor>()
        val listaAutoresNombres = ArrayList<String>();

        fun crearListaNombres() {
            var i = 0
            listaAutores.forEach(){
                listaAutoresNombres[i] = it.nombres
            }
        }

    }




}