package com.example.examen1erbim

import java.util.*

class Libro
(
    val ICBN: Int,
    val nombre: String,
    val numeroPaginas: Int,
    val edicion: Int,
    val fechaPublicacion: String,
    val nombreEditorial: String,
    val idAutor: Int
)
{
    init {
        Autor.listaAutores.get(idAutor).libros.add(this)
    }

}