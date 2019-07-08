package com.example.clinica

class Medico (
    val id:Int?,
    val nombre:String,
    val oficina:String,
    val especialidad: String
    ) {
        companion object{
            var ArrarMedicos:List<Medico>? = ArrayList()
        }
    }