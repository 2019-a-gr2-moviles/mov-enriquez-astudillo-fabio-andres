package com.example.clinica

import java.util.*
import kotlin.collections.ArrayList

class Paciente(
    val id:Int?,
    val nombre:String,
    val alergias:String,
    val fechaNac: String
) {
    companion object{
        var ArrarPacientes:List<Paciente>? = ArrayList()
    }
}