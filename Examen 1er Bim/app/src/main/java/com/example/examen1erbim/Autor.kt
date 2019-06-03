package com.example.examen1erbim

import java.util.*
import kotlin.collections.ArrayList

class Autor
(
    val nombres: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val ecuatoriano: Boolean
)


{

    val libros: ArrayList<Libro> = ArrayList<Libro>();
    val nombresLibros: ArrayList<String> = ArrayList<String>()
    var numeroLibros: Int


    init {
        numeroLibros = 0
        Autor.listaAutores.add(this)
    }

    fun cambiarNumeros(){
        this.numeroLibros = libros.size
    }

    fun crearListaNombres() {
        nombresLibros.clear()
        libros.forEach(){
            nombresLibros.add(it.nombre)
        }
    }

    companion object{
        val listaAutores = ArrayList<Autor>()
        val listaAutoresNombres = ArrayList<String>();

        fun crearListaNombres() {
            listaAutoresNombres.clear()
            listaAutores.forEach(){
                listaAutoresNombres.add(it.nombres)
            }
        }

    }




}