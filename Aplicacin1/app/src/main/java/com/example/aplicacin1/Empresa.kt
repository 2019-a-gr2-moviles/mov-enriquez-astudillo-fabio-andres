package com.example.aplicacin1

import java.util.*
import kotlin.collections.ArrayList

class Empresa (
    var id:Int,
    var nombre:String,
    var createdAt:Long,
    var updatedAt:Long,
    var usuariosDeEmpresa: ArrayList<UsuarioEmpresa>
){
    var fechaCreacion: Date
    var fechaActualización: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualización = Date(updatedAt)
    }
}