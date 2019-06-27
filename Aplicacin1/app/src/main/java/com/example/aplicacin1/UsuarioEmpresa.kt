package com.example.aplicacin1

import java.util.*

class UsuarioEmpresa (
    var createdAt: Long,
    var updatedAt:Long,
    var id:Int,
    var nombre:String,
    var fkEmpresa:Int
){
    var fechaCreacion: Date
    var fechaActualización: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualización = Date(updatedAt)
    }

}