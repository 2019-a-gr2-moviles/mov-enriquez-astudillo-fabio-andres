package com.example.examen1erbim

import java.util.*

class Libro
(
    val ICBN: Int,
    val nombre: String,
    val numeroPaginas: Int,
    val edicion: Int,
    val fechaPublicacion: Date,
    val nombreEditorial: String,
    val idAutor: Int,
    val id: Int
)
{
    init {
        Autor.listaAutores.get(idAutor).libros.add(this)
    }
}