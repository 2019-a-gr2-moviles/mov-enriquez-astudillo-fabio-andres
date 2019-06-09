package com.example.examen1erbim

import java.util.*

class Libro
(
    var ICBN: Int,
    var nombre: String,
    var numeroPaginas: Int,
    var edicion: Int,
    var fechaPublicacion: String,
    var nombreEditorial: String,
    var idAutor: Int
)
{
    init {
        Autor.listaAutores.get(idAutor).libros.add(this)
    }

}